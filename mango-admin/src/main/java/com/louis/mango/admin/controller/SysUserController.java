package com.louis.mango.admin.controller;


import com.alibaba.fastjson.JSON;
import com.louis.mango.admin.model.SysUser;
import com.louis.mango.admin.service.ISysUserService;
import com.louis.mango.common.utils.FileUtils;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
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
@Controller
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

    @RequestMapping(value = "/findPage")
    @ResponseBody
    public PageResult findPage(@RequestBody PageRequest pageRequest){
        PageResult pageResult = null;
        try {
            pageResult = iSysUserService.findPage(pageRequest);
        }catch (Exception e){
            log.info("异常信息：{},详情：{}",e.getMessage(),e);
        }
        return pageResult;
    }

    @PostMapping(value = "/exportExcelUser")
    public void exportExcelUser(@RequestBody PageRequest pageRequest, HttpServletResponse res){
        File file = iSysUserService.createUserExcelFile(pageRequest);
        FileUtils.downloadFile(res,file,file.getName());
    }
}
