package com.rental.web.staff;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.rental.QO.LocationForm;
import com.rental.QO.OrdersForm;
import com.rental.common.Result;
import com.rental.entity.*;
import com.rental.service.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller("staffOrderController")
@RequestMapping("/staff/order")
public class OrderController {
    @Autowired
    private IOrdersService ordersService;
    @Autowired
    private ILocationService iLocationService;
    @Autowired
    private ICarService carService;
    @Autowired
    private IUserService userService;

    @GetMapping("/index")
    public String toIndex() {
        return "staff/orderList";
    }

    @PostMapping(value = "/index")
    @ResponseBody
    public String index(@RequestBody OrdersForm form) {
        return ordersService.findOrders(form);
    }

    @PostMapping(value = "/cancel")
    @ResponseBody
    public Result cancel(OrdersForm form) {
        Orders orders = ordersService.selectById(form.getOrderId());

        if (orders == null) {
            return Result.fail("order is not exist");
        }
        orders.setOrderStatus(Orders.ORDER_CANCEL);
        Car car = carService.selectById(orders.getCarId());
        car.setStatus(car.RECORD);

        if (ordersService.updateById(orders) && carService.updateById(car)) {
            return Result.ok("cancel success");
        } else {
            return Result.fail("cancel fail");

        }
    }

    @PostMapping(value = "/changeStatus")
    @ResponseBody
    public Result changeStatus(OrdersForm form) {
        Orders orders = ordersService.selectById(form.getOrderId());

        if (orders == null) {
            return Result.fail("order is not exist");
        }
        if (orders.getOrderStatus() == Orders.ORDER_PICKING_UP) {
            orders.setOrderStatus(Orders.ORDER_USING);
        } else if (orders.getOrderStatus() == Orders.ORDER_USING) {
            orders.setOrderStatus(Orders.ORDER_FINISHED);
        }
        ordersService.updateById(orders);
        if (ordersService.updateById(orders)) {
            return Result.ok("change status success");
        } else {
            return Result.fail("change status fail");

        }
    }


    @GetMapping("/update/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Map<String, Object> map) {
        Orders orders = ordersService.selectById(id);
        if (orders == null) {
            return "redirect:/staff/location/index";
        }
        map.put("orders", orders);
        map.put("users", userService.selectList(new EntityWrapper<User>()
                .eq("type",1)
                .eq("is_blacklist", 0)));
        map.put("location", iLocationService.selectList(new EntityWrapper<>()));
        return "staff/updateOrder";
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public Result update(OrdersForm form) {
        Orders orders = ordersService.selectById(form.getOrderId());
        if (ordersService.updateById(form.toOrders(orders))) {
            return Result.ok("update success");
        } else {
            return Result.fail("update error");
        }
    }

    @GetMapping("/add")
    public String toAdd(Map<String, Object> map) {
        map.put("location", iLocationService.selectList(new EntityWrapper<>()));
        map.put("users", userService.selectList(new EntityWrapper<User>()
                .eq("type",1)
                .eq("is_blacklist", 0)));

        return "staff/addOrder";
    }

    @PostMapping(value = "/saveOrUpdate")
    @ResponseBody
    public Result add(OrdersForm form) {
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
            // End time-start time
            long dayHours = (dropoffTImeLong - pickupTimeLong) / (60 * 60 * 1000);
            BigDecimal hours = new BigDecimal(dayHours);
            BigDecimal amount = hours.multiply(car.getRent());
            form.setOrderAmount(amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = userService.selectById(form.getUserId());
        form.setUserId(user.getId());
        form.setUserName(user.getUsername());
        form.setUserPhone(user.getPhone());
        form.setUserAddress(user.getAddress());
        form.setCarId(car.getCid());
        form.setCarMaker(car.getMaker());
        form.setCarType(car.getType());
        if (form.getOrderId() != null) {
            if (ordersService.updateById(form.toOrders(ordersService.selectById(form.getOrderId())))) {
                return Result.ok("update order success");
            } else {
                return Result.fail("update order error");
            }
        } else {
            car.setStatus(Car.BEING_USING);
            carService.updateById(car);
            if (ordersService.insert(form.toOrders(new Orders()))) {
                return Result.ok("add order success");
            } else {
                return Result.fail("add order error");
            }
        }

    }

    @PostMapping(value = "/getCarList")
    @ResponseBody
    public Result getCarList(OrdersForm form) {
        return Result.ok(ordersService.getCarList(form));
    }

}
