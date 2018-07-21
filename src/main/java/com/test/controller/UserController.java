package com.test.controller;

import com.sun.jna.platform.unix.solaris.LibKstat;
import com.test.common.ServerReponse;
import com.test.service.IUserService;
import com.test.useDll.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping("list_byAccount.do")
    @ResponseBody
    public  ServerReponse listByAccount(@RequestParam("accountNo") int accountNo, @RequestParam("password") String password) throws UnsupportedEncodingException {
        return iUserService.getList(accountNo,password);
    }
    @RequestMapping("check_login.do")
    @ResponseBody
    public ServerReponse login(@RequestParam("accountNo") int accountNo, @RequestParam("password") String password) throws UnsupportedEncodingException {
        return iUserService.loginCheck(accountNo,password);
    }
    @RequestMapping("init.do")
    @ResponseBody
    public ServerReponse init()  {
        return iUserService.init();
    }
    @RequestMapping("read.do")
    @ResponseBody
    public ServerReponse readIC() throws UnsupportedEncodingException {
        return iUserService.readICNew();
    }
    @RequestMapping("list.do")
    @ResponseBody
    public  ServerReponse listByAccount(@RequestParam("code") String code){
        return iUserService.getUserList(code);
    }


}
