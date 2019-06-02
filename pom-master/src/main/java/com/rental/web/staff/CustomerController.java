package com.rental.web.staff;

import com.rental.QO.UserForm;
import com.rental.common.Result;
import com.rental.entity.User;
import com.rental.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller("staffCustomerController")
@RequestMapping("/staff/customer")
public class CustomerController {

    @Autowired
    private IUserService userService;

    @GetMapping("/index")
    public String toIndex(UserForm form) {
        return "staff/customerList";
    }

    @PostMapping(value = "/index")
    @ResponseBody
    public String index(@RequestBody UserForm form) {
        return userService.findCustomers(form);
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public Result update( UserForm form) {
        User user = userService.selectById(form.getId());
        if (userService.updateById(form.toUser(user))) {
            return Result.ok("update success");
        } else {
            return Result.fail("update error");
        }
    }
    @GetMapping(value = "/update/{id}")
    public String toUpdate( @PathVariable("id") Integer id,Map<String,Object> map) {
        User user = userService.selectById(id);
        if(user == null) {
            return "redirect:/staff/customer/index";
        }
        map.put("user",user);
        return "staff/customer";
    }

}
