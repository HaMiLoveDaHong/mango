package com.louis.mango.admin.service.impl;

import com.louis.mango.admin.model.SysUser;
import com.louis.mango.admin.dao.SysUserMapper;
import com.louis.mango.admin.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户管理 服务实现类
 * </p>
 *
 * @author hami
 * @since 2019-10-11
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }
}
