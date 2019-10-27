package com.louis.mango.admin.service;

import com.louis.mango.admin.model.SysDict;
import com.baomidou.mybatisplus.extension.service.IService;
import com.louis.mango.admin.vo.SysDict.SysDictRequestVo;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author hami
 * @since 2019-10-11
 */
public interface ISysDictService extends IService<SysDict> {

    /**
     * 根据名称查询
     * @param lable
     * @return
     */
    List<SysDict> findByLable(String lable);

    /**
     * 分页查询
     * @return
     */
    PageResult findPage(SysDictRequestVo pageRequest);

    /**
     * 根据标签名称分页查询
     * @return
     */
    PageResult findPageByLable(SysDictRequestVo pageRequest);

    /**
     * 根据主键id删除记录
     * @param requestVo
     */
    void deleteById(SysDictRequestVo requestVo);
}
