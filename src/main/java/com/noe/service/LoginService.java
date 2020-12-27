package com.noe.service;

import com.noe.bean.TblUserRecord;
import com.noe.mapper.TblUserRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @descriptions:
 * @author: noe
 * @date:
 */
@Service
public class LoginService {

    @Autowired
    private TblUserRecordMapper tblUserRecordMapper;

    public TblUserRecord login(String username, String password) {

//        TblUserRecord tblUserRecord = ;
//        System.out.println(tblUserRecord.toString());
        return tblUserRecordMapper.login(username, password);
    }

}
