package com.louis.mango.admin.controller;


import com.louis.mango.admin.model.SysDict;
import com.louis.mango.admin.service.ISysDictService;
import com.louis.mango.admin.vo.SysDict.SysDictRequestVo;
import com.louis.mango.core.http.HttpResult;
import com.louis.mango.core.page.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author hami
 * @since 2019-10-11
 */
@Slf4j
@RestController
@RequestMapping("/admin/sys-dict")
public class SysDictController {
    @Autowired
    ISysDictService sysDictService;

    /**
     * 保存接口
     *
     * @param sysDict
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysDict sysDict) {
        String title = "/admin/sys-dict/save";
        log.info("访问:{},开始", title);
        HttpResult httpResult = new HttpResult();
        try {
            sysDictService.save(sysDict);
            httpResult.setData(sysDict);
        } catch (Exception e) {
            httpResult = httpResult.error(e.getMessage());
            log.info("接口异常,信息:{},详情:{}", e.getMessage(), e);
        } finally {
            log.info("访问:{},结束", title);
        }
        return httpResult;
    }

    /**
     * 删除接口
     *
     * @param requestVo
     * @return
     */
    @PostMapping(value = "/deleteById")
    public HttpResult deleteById(@RequestBody SysDictRequestVo requestVo) {
        String title = "/admin/sys-dict/deleteById";
        log.info("访问:{},开始", title);
        HttpResult httpResult = new HttpResult();
        try {
            sysDictService.deleteById(requestVo);
        } catch (Exception e) {
            httpResult = httpResult.error(e.getMessage());
            log.info("接口异常,信息:{},详情:{}", e.getMessage(), e);
        } finally {
            log.info("访问:{},结束", title);
        }
        return httpResult;
    }

    /**
     * 查询接口
     *
     * @param requestVo
     * @return
     */
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody SysDictRequestVo requestVo) {
        String title = "/admin/sys-dict/findPage";
        log.info("访问:{},开始", title);
        HttpResult httpResult = new HttpResult();
        try {
            PageResult pageResult = sysDictService.findPage(requestVo);
            httpResult.setData(pageResult);
        } catch (Exception e) {
            httpResult = httpResult.error(e.getMessage());
            log.info("接口异常,信息:{},详情:{}", e.getMessage(), e);
        } finally {
            log.info("访问:{},结束", title);
        }
        return httpResult;
    }

    /**
     * 根据标签查询接口
     *
     * @param requestVo
     * @return
     */
    @PostMapping(value = "/findByLable")
    public HttpResult findByLable(@RequestBody SysDictRequestVo requestVo) {
        String title = "/admin/sys-dict/findByLable";
        log.info("访问:{},开始", title);
        HttpResult httpResult = new HttpResult();
        try {
            List<SysDict> sysDicts = sysDictService.findByLable(requestVo.getLable());
            httpResult.setData(sysDicts);
        } catch (Exception e) {
            httpResult = httpResult.error(e.getMessage());
            log.info("接口异常,信息:{},详情:{}", e.getMessage(), e);
        } finally {
            log.info("访问:{},结束", title);
        }
        return httpResult;
    }
}
