package com.noe.service.impl;

import com.noe.bean.TblEmployeeContact;
import com.noe.mapper.TblEmployeeContactMapper;
import com.noe.service.base.TblEmployeeContactService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工通讯录 服务实现类
 * </p>
 *
 * @author lian
 * @since 2020-12-26
 */
@Service
public class TblEmployeeContactServiceImpl extends ServiceImpl<TblEmployeeContactMapper, TblEmployeeContact> implements TblEmployeeContactService {

}
