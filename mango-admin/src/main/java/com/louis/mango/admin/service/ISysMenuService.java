package com.louis.mango.admin.service;

import com.louis.mango.admin.model.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author hami
 * @since 2019-10-11
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 根据用户名查找菜单列表
     *
     * @param userName
     * @return
     */
    List<SysMenu> findByUser(String userName);
}
