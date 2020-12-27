package com.noe.service;

import com.noe.bean.TblCompany;
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

    public List<TblCompany> selectCompany() {
        List<TblCompany> companys = tblCompanyMapper.selectCompanyName();
        return companys;
    }

}
