package com.cave.springbootdemo.example4.web;

import com.cave.springbootdemo.example4.pojo.User;
import com.cave.springbootdemo.example4.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 包含Controller + ResponseBody
@RequestMapping("/user")
public class UserController {

    /**
     * RESTful GET请求方式查询数据
     * @param nickName
     * @return
     */
    @ApiOperation(value = "根据nickName查询User", notes = "GET请求方式查询数据")
    // value相当于方法名, notes相当于对这个访问的描述
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickName", value = "昵称", required = true, paramType = "path")
    })
    // 如果有多个参数，需要使用Params，PS：注意各个属性的默认值
    @GetMapping("/find/{nickName}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "test")
    })
    // 表示多个响应值
    public List<User> findUserByNickName(@PathVariable String nickName){
        return userService.findUserByNickName(nickName);
    }

    /**
     * RESTful POST请求方式添加数据
     * @return
     */
    @PostMapping("/add")
    public void addUser(User user){
        userService.addUser(user);
    }

    /**
     * RESTful PUT请求方式更新数据
     * @param user
     * @return
     */
    @PutMapping("/update")
    public void updateUser(User user){
        userService.updateUser(user);
    }

    /**
     * RESTful DELETE请求方式删除数据
     * @param uid
     */
    @DeleteMapping("/delete/{uid}")
    public void deleteUser(@PathVariable String uid){
        userService.deleteUser(uid);
    }

    @Autowired
    private UserService userService;

}
