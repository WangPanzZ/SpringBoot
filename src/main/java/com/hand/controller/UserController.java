package com.hand.controller;

import com.hand.model.User;
import com.hand.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangPan
 * @title UserController
 * @description
 * @date: 2018/4/24 13:05
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*method - 指定请求的方法类型：POST/GET/DELETE/PUT 等
    value - 指定实际的请求地址
    consumes - 指定处理请求的提交内容类型，例如 Content-Type 头部设置application/json, text/html
    produces - 指定返回的内容类型*/

    /*@ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    public int addUser(User user){
        System.out.println(""+user.getUserName());
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }*/

    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={""}, method=RequestMethod.GET)
    public List<User> getUserList() {
        List<User> u = new ArrayList<User>(users.values());
        return u;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        users.put(user.getUserId(), user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        return users.get(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Integer id, @RequestBody User user) {
        User u = users.get(id);
        u.setUserName(user.getUserName());
        u.setPassword(user.getPassword());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id) {
        users.remove(id);
        return "success";
    }

    /**
     * @Api：用在类上，说明该类的作用
     * @ApiOperation：用在方法上，说明方法的作用
     * @ApiImplicitParams：用在方法上包含一组参数说明
     * @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
     * paramType：参数放在哪个地方
     * header-->请求参数的获取：@RequestHeader
     * query-->请求参数的获取：@RequestParam
     * path（用于restful接口）-->请求参数的获取：@PathVariable
     * body（不常用）
     * form（不常用）
     * name：参数名
     * dataType：参数类型
     * required：参数是否必须传
     * value：参数的意思
     * defaultValue：参数的默认值
     * @ApiResponses：用于表示一组响应
     * @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
     * code：数字，例如400
     * message：信息，例如"请求参数没填好"
     * response：抛出异常的类
     * @ApiModel：描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候）
     * @ApiModelProperty：描述一个model的属性
     */
}
