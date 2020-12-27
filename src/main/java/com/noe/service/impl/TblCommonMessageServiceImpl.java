package com.noe.service.impl;

import com.noe.bean.TblCommonMessage;
import com.noe.mapper.TblCommonMessageMapper;
import com.noe.service.base.TblCommonMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 常用短信 服务实现类
 * </p>
 *
 * @author lian
 * @since 2020-12-26
 */
@Service
public class TblCommonMessageServiceImpl extends ServiceImpl<TblCommonMessageMapper, TblCommonMessage> implements TblCommonMessageService {

}
