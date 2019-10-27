package com.louis.mango.core.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * Mybatis 分页查询助手
 * @quthor haMi
 * @date2019/10/19
 */
public class MybatisPageHelper {

    public static final String findPage = "findPage";

    /**
     * 分页查询，约定查询方法名为"findPage"
     * @param pageRequest 分页请求
     * @param mapper Dao 对象，MyBatis 的Mapper
     * @return
     */
    public static PageResult findPage(PageRequest pageRequest,Object mapper){
        return findPage(pageRequest,mapper,findPage);
    }

    /**
     *
     * @param pageRequest 分页请求
     * @param mapper dao对象，MyBatis 的 Mapper
     * @param queryMethodName 要分页的查询方法名
     * @param args 方法参数
     * @return
     */
    public static PageResult findPage(PageRequest pageRequest,Object mapper,String queryMethodName,Object... args){
        //设置分页参数
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        //利用反射查询方法
        Method method = ReflectionUtils.findMethod(mapper.getClass(),queryMethodName);
        Object result = ReflectionUtils.invokeMethod(method,mapper,args);
        return getPageResult(pageRequest,new PageInfo((java.util.List) result));
    }

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
