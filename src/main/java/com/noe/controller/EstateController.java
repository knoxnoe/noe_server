package com.noe.controller;

import com.alibaba.fastjson.JSONObject;
import com.noe.bean.TblCompany;
import com.noe.returnJson.ReturnObject;
import com.noe.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @descriptions:
 * @author: noe
 * @date:
 */
@RestController
public class EstateController {

    @Autowired
    EstateService estateService;

    @RequestMapping("/estate/selectCompany")
    public String selectCompany() {
        List<TblCompany> Companies = estateService.selectCompany();

        return JSONObject.toJSONString(new ReturnObject(Companies));
    }

}
