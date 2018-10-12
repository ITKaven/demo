package com.kaven.demo.controller;

import com.kaven.demo.model.User;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author Kaven
 * @date 2018/10/10 16:37
 */
@RestController
@RequestMapping(value = "/")
public class loginController {

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, @Valid User user, Errors errors ,
                              @RequestParam(value = "username" ) String username ,
                              @RequestParam(value = "password" ) String password){
        if(errors.hasErrors()){
            modelAndView.addObject("error",errors.getFieldError().getDefaultMessage());
            System.out.print(modelAndView);
            modelAndView.setViewName("login");
            return modelAndView;
        }

        if(!"admin".equals(username)){
            modelAndView.addObject("error","无此用户！");
            modelAndView.addObject("username",username);
            modelAndView.addObject("password",password);
            System.out.print(modelAndView);
            modelAndView.setViewName("error/usernameerror");
            return modelAndView;
        }
        if(!"123456".equals(password)){
            modelAndView.addObject("error","密码错误！");
            modelAndView.addObject("username",username);
            modelAndView.addObject("password",password);
            System.out.print(modelAndView);
            modelAndView.setViewName("error/passworderror");
            return modelAndView;
        }
        modelAndView.addObject("username",username);
        modelAndView.addObject("password",password);
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
