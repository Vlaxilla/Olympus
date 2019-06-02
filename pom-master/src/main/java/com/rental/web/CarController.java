package com.rental.web;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.rental.QO.BaseInfoForm;
import com.rental.QO.CarForm;
import com.rental.QO.OrdersForm;
import com.rental.common.Result;
import com.rental.entity.*;
import com.rental.service.ICarService;
import com.rental.service.ILocationCarService;
import com.rental.service.ILocationService;
import com.rental.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/car")
@Controller
public class CarController {
    @Autowired
    private ICarService carService;
    @Autowired
    private ILocationService locationService;
    @Autowired
    private ILocationCarService locationCarService;
    @Autowired
    private IOrdersService ordersService;

    @GetMapping("/index")
    public String toIndex(@RequestParam(required = false) CarForm form, Map<String, Object> map,
                          @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                          @RequestParam(required = false) String maker,
                          @RequestParam(required = false) String model
    ) {
        if (form == null) {
            form = new CarForm();
        }
        if (maker != null) {
            form.setMaker(maker);
        }
        if (model != null) {
            form.setModel(model);
        }
        form.setPageNumber(pageNum);
        form.setPageSize(BaseInfoForm.DEFAULT_PAGE_SIZE);
        Result result = carService.findAvailableCar(form);
        map.put("result", result);
        map.put("makers", carService.findMaker());
        map.put("makerStr", maker);
        map.put("model", model);
        return "carList";
    }

    @RequestMapping("/detail/{id}")
    public String toDetail(@PathVariable("id") Integer carId,
                           @RequestParam(value = "dropoffLocation", required = false) String dropoffLocation,
                           Map<String, Object> map) {
        map.put("car", carService.selectById(carId));
        LocationCar locationCar = locationCarService.selectOne(new EntityWrapper<LocationCar>().eq("cid", carId));
        map.put("location", locationService.selectById(locationCar.getLocationId()));
        map.put("dropoffLocation", dropoffLocation);
        return "carDetail";
    }

    @GetMapping("/map")
    public String map(Integer cid, Map<String, Object> map) {
        List<Location> locations = locationService.selectList(new EntityWrapper<>());
        map.put("locationList", JSON.toJSONString(locations));
        map.put("cid", cid);
        return "map";
    }

    @GetMapping("/comfirmLocation")
    public ModelAndView comfirmLocation(@RequestParam(name = "type") String type,
                                        @RequestParam(name = "location") String location, Map<String, Object> map) {
        map.put("location", location);
        map.put("type", type);
        return new ModelAndView("/index", map);
    }

    @PostMapping(value = "/rent")
    @ResponseBody
    public Result add(OrdersForm form, HttpSession session) {
        Car car = carService.selectById(form.getCarId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date pickupTime = sdf.parse(form.getPickupTimeStr());
            Date dropoffTIme = sdf.parse(form.getDropoffTimeStr());
            form.setPickupTime(pickupTime);
            form.setDropoffTime(dropoffTIme);
            //Calculate the rent
            long pickupTimeLong = pickupTime.getTime();
            long dropoffTImeLong = dropoffTIme.getTime();
            // End time - start time
            long dayHours = (dropoffTImeLong - pickupTimeLong) / (60 * 60 * 1000);
            BigDecimal hours = new BigDecimal(dayHours);
            BigDecimal amount = hours.multiply(car.getRent());
            form.setOrderAmount(amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = (User) session.getAttribute("user");
        form.setUserId(user.getId());
        form.setUserName(user.getUsername());
        form.setUserPhone(user.getPhone());
        form.setUserAddress(user.getAddress());
        form.setCarId(car.getCid());
        form.setCarMaker(car.getMaker());
        form.setCarType(car.getType());
        if (ordersService.insert(form.toOrders(new Orders()))) {
            car.setStatus(Car.BEING_USING);
            carService.updateById(car);
            return Result.ok("rent order success");
        } else {
            return Result.fail("rent order error");
        }

    }
}
