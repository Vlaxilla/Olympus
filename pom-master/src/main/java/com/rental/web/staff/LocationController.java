package com.rental.web.staff;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.rental.QO.CarForm;
import com.rental.QO.LocationForm;
import com.rental.common.Result;
import com.rental.entity.Car;
import com.rental.entity.Location;
import com.rental.entity.LocationCar;
import com.rental.service.ICarService;
import com.rental.service.ILocationCarService;
import com.rental.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller("staffLocationController")
@RequestMapping("/staff/location")
public class LocationController {
    @Autowired
    private ILocationService locationService;
    @Autowired
    private ILocationCarService locationCarService;
    @Autowired
    private ICarService carService;

    @GetMapping("/index")
    public String toIndex() {
        return "staff/locationList";
    }

    @PostMapping(value = "/index")
    @ResponseBody
    public String index(@RequestBody LocationForm form) {
        return locationService.findLocations(form);
    }

    @GetMapping("/update/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Map<String, Object> map) {
        Location location = locationService.selectById(id);
        if (location == null) {
            return "redirect:/staff/location/index";
        }
        map.put("location", location);
        return "staff/updateLocation";
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public Result update(LocationForm form) {
        Location location = locationService.selectById(form.getLocationId());
        if (locationService.updateById(form.toLocation(location))) {
            return Result.ok("update success");
        } else {
            return Result.fail("update error");
        }
    }

    @GetMapping("/add")
    public String toAdd() {
        return "staff/addLocation";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public Result add(LocationForm form) {
        if (locationService.insert(form.toLocation(new Location()))) {
            return Result.ok("add location success");
        } else {
            return Result.fail("add location error");
        }
    }


    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        locationService.deleteById(id);
        locationCarService.delete(new EntityWrapper<LocationCar>().eq("location_id", id));
        return "redirect:/staff/location/index";
    }

    @GetMapping("/showCar/{id}")
    public String toShowCar(@PathVariable("id") Integer id, Map<String, Object> map) {
        map.put("id", id);
        return "staff/showCar";
    }

    @PostMapping(value = "/showCar")
    @ResponseBody
    public String showCar(@RequestBody LocationForm form) {
        return locationService.showCar(form);
    }

    @PostMapping(value = "/removeCar")
    @ResponseBody
    public Result removeCar(LocationForm form) {

        if (locationCarService.delete(new EntityWrapper<LocationCar>()
                .eq("location_id", form.getLocationId())
                .eq("cid", form.getCid()))) {
            Car car = carService.selectById(form.getCid());
            car.setStatus(Car.NEW_CAR);
            carService.updateById(car);
            return Result.ok("remove car success");
        } else {
            return Result.fail("remove car error");
        }
    }

    @GetMapping("/addCar/{id}")
    public String toAddCar(@PathVariable("id") Integer id, Map<String, Object> map) {
        map.put("id", id);
        return "staff/addLocationCar";
    }

    @GetMapping(value = "/showNoRelateCar/{id}")
    public String toShowNoRelateCar(@PathVariable("id") Integer id, Map<String, Object> map) {
        map.put("id", id);
        return "staff/showNoRelateCar";
    }

    @PostMapping(value = "/showNoRelateCar")
    @ResponseBody
    public String showNoRelateCar(@RequestBody LocationForm form) {
        return locationService.showNoRelateCar(form);
    }

    @PostMapping(value = "/addCar")
    @ResponseBody
    public Result addCar(LocationForm form) {
        if (form.getLocationId() == null || form.getCid() == null) {
            return Result.fail("params error");
        }
        LocationCar locationCar = new LocationCar();
        locationCar.setCid(form.getCid());
        locationCar.setLocationId(form.getLocationId());
        if (locationCarService.insert(locationCar)) {
            Car car = carService.selectById(form.getCid());
            car.setStatus(Car.RECORD);
            carService.updateById(car);
            return Result.ok("add car to location success");
        } else {
            return Result.fail("add car to location error");
        }
    }
}
