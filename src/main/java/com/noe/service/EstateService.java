package com.noe.service;

import com.noe.bean.FcEstate;
import com.noe.bean.TblCompany;
import com.noe.mapper.FcEstateMapper;
import com.noe.mapper.TblCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private FcEstateMapper fcEstateMapper;

    public List<TblCompany> selectCompany() {
        List<TblCompany> companys = tblCompanyMapper.selectCompanyName();
        return companys;
    }

    public Integer insertEstate(FcEstate fcEstate) {
        int res = fcEstateMapper.insert(fcEstate);
        return res;
    }


}
