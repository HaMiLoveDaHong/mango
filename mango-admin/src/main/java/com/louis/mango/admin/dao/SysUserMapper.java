package com.louis.mango.admin.dao;

import com.louis.mango.admin.model.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 用户管理 Mapper 接口
 * </p>
 *
 * @author hami
 * @since 2019-10-11
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 查询全部
     * @return
     */
    List<SysUser> findAll();
}
