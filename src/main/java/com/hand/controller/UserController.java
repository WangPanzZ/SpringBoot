package com.hand.controller;

import com.hand.model.User;
import com.hand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author WangPan
 * @title UserController
 * @description
 * @date: 2018/4/24 13:05
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*method - 指定请求的方法类型：POST/GET/DELETE/PUT 等
    value - 指定实际的请求地址
    consumes - 指定处理请求的提交内容类型，例如 Content-Type 头部设置application/json, text/html
    produces - 指定返回的内容类型*/

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    public int addUser(User user){
        System.out.println(""+user.getUserName());
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }
}
