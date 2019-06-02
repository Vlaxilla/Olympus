package com.rental.web.staff;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @RequestMapping("/index")
    public String toIndex() {
        return "staff/index";
    }
}
