package com.louis.mango.admin.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.louis.mango.admin.model.SysDict;
import com.louis.mango.admin.dao.SysDictMapper;
import com.louis.mango.admin.service.ISysDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.louis.mango.admin.vo.SysDict.SysDictRequestVo;
import com.louis.mango.core.page.MybatisPageHelper;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author hami
 * @since 2019-10-11
 */
@Slf4j
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {

    @Override
    public List<SysDict> findByLable(String lable) {
        return super.baseMapper.findByLable(lable);
    }

    @Override
    public PageResult findPage(SysDictRequestVo pageRequest) {
        PageResult result = null;
        if (StringUtil.isEmpty(pageRequest.getLable())){
            result = MybatisPageHelper.findPage(pageRequest,super.baseMapper);
        }else {
            result = findPageByLable(pageRequest);
        }
        return result;
    }

    @Override
    public PageResult findPageByLable(SysDictRequestVo pageRequest) {
        //baseMapper 的方法名称
        String queryMethodName = "findPageByLable";
        return MybatisPageHelper.findPage(pageRequest,super.baseMapper,queryMethodName,pageRequest.getLable());
    }

    @Override
    public void deleteById(SysDictRequestVo requestVo) {
        super.baseMapper.deleteById(requestVo.getId());
    }
}
