package com.noe.service.impl;

import com.noe.bean.TblMyNote;
import com.noe.mapper.TblMyNoteMapper;
import com.noe.service.base.TblMyNoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 我的记事本 服务实现类
 * </p>
 *
 * @author lian
 * @since 2020-12-26
 */
@Service
public class TblMyNoteServiceImpl extends ServiceImpl<TblMyNoteMapper, TblMyNote> implements TblMyNoteService {

}
