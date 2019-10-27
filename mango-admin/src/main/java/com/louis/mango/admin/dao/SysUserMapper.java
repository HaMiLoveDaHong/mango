package com.louis.mango.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.louis.mango.admin.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 用户管理 Mapper 接口
 * </p>
 *
 * @author hami
 * @since 2019-10-11
 */
@Component
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 查询全部
     * @return
     */
    List<SysUser> findAll();

    /**
     * 查询记录分页
     * @return
     */
    List<SysUser> findPage();
}
