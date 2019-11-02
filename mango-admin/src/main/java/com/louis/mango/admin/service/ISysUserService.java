package com.louis.mango.admin.service;

import com.louis.mango.admin.model.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;

import java.io.File;
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

    /**
     * 查询记录分页
     * @param pageRequest
     * @return
     */
    PageResult findPage(PageRequest pageRequest);

    /**
     * 生成用户信息Excel文件
     * @param pageRequest
     * @return
     */
    File createUserExcelFile(PageRequest pageRequest);
}
