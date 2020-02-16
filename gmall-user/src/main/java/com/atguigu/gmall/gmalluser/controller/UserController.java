package com.atguigu.gmall.gmalluser.controller;

import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember>  getAllUser(){
        List<UmsMember > allUser = userService.getAllUser();
        return allUser;
    }
    //删除用户
    @RequestMapping("deleteUserById")
    @ResponseBody
    public int deleteUserById(String id){
        int deleteUmsMember = userService.deleteUserById(id);
        return deleteUmsMember;
    }
    //更改用户信息
    @RequestMapping("updateUserById")
    @ResponseBody
    public int updateUserById(String id){
        int update = userService.updateUserById(id);
        return  update;
    }
    @RequestMapping("updateUser")
    @ResponseBody
    public int updateUser(UmsMember umsMember){
        int update=userService.updateUser(umsMember);
        return update;
    }

    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress>  getReceiveAddressByMemberId(String memberId){
        List<UmsMemberReceiveAddress> receiveAddress = userService.getReceiveAddressByMemberId(memberId);
        return receiveAddress;
    }
}
