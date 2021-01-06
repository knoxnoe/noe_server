package com.noe.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.noe.bean.FcBuilding;
import com.noe.bean.FcEstate;
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

    @RequestMapping("/estate/insertEstate")
    public String insertEstate(FcEstate fcEstate) {
        Integer res = estateService.insertEstate(fcEstate);
        System.out.println("insert Estate"+res);
        if(res != 0) {
            return JSONObject.toJSONString(new ReturnObject("插入房产成功!", "1"));
        } else {
            return JSONObject.toJSONString(new ReturnObject("房产重复!", "0"));
        }
    }

    /**
     * @descriptions: 楼宇查询功能
     * @param:
     * @return:
     */
    @RequestMapping("/estate/selectBuilding")
    public String selectBuilding(Integer buildingNumber, String estateCode) {
        List<FcBuilding> fcBuildings = estateService.selectBuilding(buildingNumber, estateCode);

        return JSONObject.toJSONString(new ReturnObject(fcBuildings));
    }

    @RequestMapping("/estate/updateBuilding")
    public String updateBuilding(FcBuilding fcBuilding) {
        Integer res = estateService.updateBuilding(fcBuilding);
        if(res == 1) {
            return JSONObject.toJSONString(new ReturnObject("保存成功！", "1"));
        }
        return JSONObject.toJSONString(new ReturnObject("保存失败！", "0"));
    }

}
