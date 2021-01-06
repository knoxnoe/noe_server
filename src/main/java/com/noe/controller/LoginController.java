package com.noe.controller;

import com.alibaba.fastjson.JSONObject;
import com.noe.bean.TblUserRecord;
import com.noe.returnJson.Permission;
import com.noe.returnJson.Permissions;
import com.noe.returnJson.ReturnObject;
import com.noe.returnJson.UserInfo;
import com.noe.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @descriptions:
 * @author: noe
 * @date:
 */
@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {})
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/auth/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {

//        System.out.println(username);
//        System.out.println(password);
        TblUserRecord tblUserRecord = loginService.login(username, password);
        tblUserRecord.setToken(tblUserRecord.getUserName());

        // 将用户数据写入到session
        session.setAttribute("userRecord", tblUserRecord);
        System.out.println("LoginController.java login"+tblUserRecord.toString());

        ReturnObject returnObject = new ReturnObject(tblUserRecord);
        return JSONObject.toJSONString(returnObject);
    }

    @RequestMapping("/user/info")
    public String getInfo(HttpSession session) { // 跨域导致session共享失败
        TblUserRecord tblUserRecord = (TblUserRecord)session.getAttribute("userRecord");
        // 获取模块信息
        String[] split = tblUserRecord.getTblRole().getRolePrivileges().split("-");
        Permissions permissions = new Permissions();
        List<Permission> permissionList = new ArrayList<>();
        for(String s : split) {
            permissionList.add(new Permission(s));
        }
        permissions.setPermissions(permissionList);
        UserInfo userInfo = new UserInfo(tblUserRecord.getUserName(), permissions);
        return JSONObject.toJSONString(new ReturnObject(userInfo));
    }

    @RequestMapping("/auth/logout")
    public void logOut(HttpSession session) {
        System.out.println("logout");
        session.invalidate();
    }

    @RequestMapping("/auth/2step-code")
    public boolean get2step() {
        return true;
    }


}
