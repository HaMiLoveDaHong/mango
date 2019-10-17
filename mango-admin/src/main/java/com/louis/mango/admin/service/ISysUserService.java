package com.louis.mango.admin.service;

import com.louis.mango.admin.model.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户管理 服务类
 * </p>
 *
 * @author hami
 * @since 2019-10-11
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 查询所有用户记录
     * @return
     */
    List<SysUser> findAll();

}
