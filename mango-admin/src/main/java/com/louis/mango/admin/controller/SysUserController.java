package com.louis.mango.admin.controller;


import com.alibaba.fastjson.JSON;
import com.louis.mango.admin.model.SysUser;
import com.louis.mango.admin.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户管理 前端控制器
 * </p>
 *
 * @author hami
 * @since 2019-10-11
 */
@Slf4j
@RestController
@RequestMapping("/admin/sys-user")
public class SysUserController {

    @Autowired
    ISysUserService iSysUserService;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public String findAll(){
        List<SysUser> sysUsers = iSysUserService.findAll();
        return JSON.toJSONString(sysUsers);
    }
}
