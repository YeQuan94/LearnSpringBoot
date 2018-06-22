package com.cave.springbootdemo.example4.web;

import com.cave.springbootdemo.example4.pojo.User;
import com.cave.springbootdemo.example4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // 包含Controller + ResponseBody
@RequestMapping("/user")
public class UserController {

    /**
     * RESTful GET请求方式查询数据
     * @param nickName
     * @return
     */
    @GetMapping("/find/{nickName}")
    public List<User> findUserByNickName(@PathVariable String nickName){
        return userService.findUserByNickName(nickName);
    }

    // TODO 添加 删除 修改 1.普通参数 2.JSON参数

    @Autowired
    private UserService userService;

}
