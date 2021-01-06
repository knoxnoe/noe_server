package com.noe.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noe.bean.FcBuilding;
import com.noe.bean.FcEstate;
import com.noe.bean.TblCompany;
import com.noe.mapper.FcBuildingMapper;
import com.noe.mapper.FcEstateMapper;
import com.noe.mapper.TblCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @descriptions:
 * @author: noe
 * @date:
 */
@Service
public class EstateService {

    @Autowired
    private TblCompanyMapper tblCompanyMapper;

    public List<TblCompany> selectCompany() {
        List<TblCompany> companys = tblCompanyMapper.selectCompanyName();
        return companys;
    }

    /**
     * @descriptions: 再插入数据之前对当前信息做判断，判断住宅编码是否存在，如果存在则不允许插入，如果不存在才允许插入
     * @param:
     * @return:
     */
    @Autowired
    private FcEstateMapper fcEstateMapper;

    public Integer insertEstate(FcEstate fcEstate) {
        // 定义查询包装类
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("estate_code", fcEstate.getEstateCode());
        FcEstate findResult = fcEstateMapper.selectOne(queryWrapper);
        int result = 0;
        // 如果没有可以插入
        if(findResult == null) {
            result = fcEstateMapper.insert(fcEstate);
        }
        return result;
    }

//    public boolean isExit(String fileds, Object id, BaseMapper<?> mapper, Object entity) {
//
//        Class clazz = entity.getClass();
//
//        // 定义查询包装类
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq(fileds, id);
//        clazz o = mapper.selectOne(queryWrapper);
//        System.out.println(mapper.getClass());
//        return false;
//    }

    /**
     * @descriptions: 先插入数据再查询
     * @param:
     * @return:
     */
    @Autowired
    private FcBuildingMapper fcBuildingMapper;

    public List<FcBuilding> selectBuilding(Integer buildingNumer, String estateCode) {
        List<FcBuilding> fcBuildings = new ArrayList<>();
        for (int i = 0; i < buildingNumer; i++) {
            FcBuilding fcBuilding = new FcBuilding();
            fcBuilding.setBuildingCode("B"+(i+1));
            fcBuilding.setBuildingName("第" + (i+1) + "号楼");
            fcBuilding.setEstateCode(estateCode);
            fcBuildingMapper.insert(fcBuilding);
            fcBuildings.add(fcBuilding);
        }
        return fcBuildings;
    }

    public Integer updateBuilding(FcBuilding fcBuilding) {
        System.out.println("更新楼宇状态");
        int res = fcBuildingMapper.updateById(fcBuilding);
        return res;
    }


}
