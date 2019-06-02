package com.rental.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.rental.QO.CarForm;
import com.rental.common.Result;
import com.rental.entity.Car;
import com.rental.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private ICarService carService;

    @RequestMapping({"/", "/index", "/index.html"})
    public String index(Map<String, Object> map) {

        List<Car> cars = carService.selectList(new EntityWrapper<Car>()
                .eq("disable", 0)
                .ne("status", Car.NEW_CAR).orderBy("create_time"));

        if (cars.size() > 7) {
            map.put("carList", cars.subList(0, 7));
        }
        if (cars.size() > 3) {
            map.put("carCase", cars.subList(0, 3));
        }
        return "index";
    }

    @GetMapping({"/login", "/login.html"})
    public String toLogin() {
        return "login";
    }

    @GetMapping({"/profile", "/profile.html"})
    public String toProfile(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        return "profile";
    }

    @GetMapping({"/sign-up", "/sign-up.html"})
    public String toSignUp() {
        return "sign-up";
    }

    @RequestMapping({"/about", "/about.html"})
    public String toAbout() {
        return "about";
    }

    @RequestMapping({"/contactus", "/contactus.html"})
    public String toContactus() {
        return "contactus";
    }

    @PostMapping(value = "/getCarList")
    @ResponseBody
    public String index(CarForm form) {
        return Result.genResponse(Result.ok(carService.selectList(form.toWrapper())));
    }


}
