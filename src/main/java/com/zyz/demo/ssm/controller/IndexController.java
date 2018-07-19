package com.zyz.demo.ssm.controller;

import com.zyz.demo.ssm.model.User;
import com.zyz.demo.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("login.action")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password) {
        User user = userService.selectUserByName(username);
        String pwd = user.getPassword();
        if (pwd.equals(password)) {
            return "success";
        }
        return "failure";
    }

    @RequestMapping("register.action")
    public String register(@RequestParam(value = "username") String username,
                           @RequestParam(value = "password") String password,
                           Model model) {
        User user = new User(username, password);
        boolean success = userService.saveUser(user);
        model.addAttribute("user", user);
        if (success) {
            return "userinfo";
        }
        return "failure";
    }
}
