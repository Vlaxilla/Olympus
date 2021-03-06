package com.rental.web.staff;

import com.rental.QO.CarForm;
import com.rental.QO.UserForm;
import com.rental.common.Result;
import com.rental.entity.Car;
import com.rental.entity.User;
import com.rental.service.ICarService;
import com.rental.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.UUID;

@Controller("staffCarController")
@RequestMapping("/staff/car")
public class CarController {
    @Autowired
    private ICarService carService;
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    @GetMapping("/index")
    public String toIndex() {
        return "staff/carList";
    }

    @PostMapping(value = "/index")
    @ResponseBody
    public String index(@RequestBody CarForm form) {
        return carService.findCars(form);
    }

    @GetMapping("/update/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Map<String, Object> map) {
        Car car = carService.selectById(id);
        if (car == null) {
            return "redirect:/staff/car/index";
        }
        map.put("car", car);
        return "staff/updateCar";
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public Result update(CarForm form) {
        Car car = carService.selectById(form.getCid());
        try {
            form.setProductTime(format.parse(form.getProductTimeStr()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (carService.updateById(form.toCar(car))) {
            return Result.ok("update success");
        } else {
            return Result.fail("update error");
        }
    }

    @GetMapping("/add")
    public String toAdd() {
        return "staff/addCar";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public Result add(CarForm form) {
        try {
            form.setProductTime(format.parse(form.getProductTimeStr()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (carService.insert(form.toCar(new Car()))) {
            return Result.ok("add car success");
        } else {
            return Result.fail("add car error");
        }
    }


    @PostMapping(value = "/upload")
    @ResponseBody
    public Result upload(@RequestParam(value = "iconFile") MultipartFile iconFile) {
        return Result.ok("upload success", uploadImg(iconFile));
    }


    /**
     * Photo storage
     *
     * @param file
     * @return
     */
    private String uploadImg(MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }
        String fileName = file.getOriginalFilename();  // File name?
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // Suffix?
        String filePath = "Y:/rental/imgs/";
        fileName = UUID.randomUUID() + suffixName; //New file name
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/imgs/" + fileName;
        return filename;
    }
}
