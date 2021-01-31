package com.louis.mango.admin.service.impl;

import com.louis.mango.admin.config.Constants;
import com.louis.mango.admin.model.SysMenu;
import com.louis.mango.admin.dao.SysMenuMapper;
import com.louis.mango.admin.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author hami
 * @since 2019-10-11
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> findByUser(String userName) {
        if(userName == null || "".equals(userName) || Constants.ADMIN.equalsIgnoreCase(userName)) {
            return sysMenuMapper.findAll();
        }
        return sysMenuMapper.findByUserName(userName);
    }
}
