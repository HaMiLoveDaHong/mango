package com.louis.mango.admin.dao;

import com.louis.mango.admin.model.SysDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author hami
 * @since 2019-10-11
 */
@Component
@Mapper
public interface SysDictMapper extends BaseMapper<SysDict> {

    /**
     * 分页查询
     *
     * @return
     */
    List<SysDict> findPage();

    /**
     * 根据标签名称查询
     *
     * @param lable
     * @return
     */
    List<SysDict> findByLable(@Param(value = "lable") String lable);

    /**
     * 根据标签名称分页查询
     *
     * @param lable
     * @return
     */
    List<SysDict> findPageByLable(@Param(value = "lable") String lable);
}
