package com.louis.mango;

import com.alibaba.fastjson.JSON;
import com.louis.mango.admin.MangoAdminApplication;
import com.louis.mango.admin.model.SysUser;
import com.louis.mango.admin.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MangoAdminApplication.class)
@Slf4j
public class MangoAdminApplicationTests {
    @Autowired
    ISysUserService iSysUserService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void findAll(){
//        SysUser sysUser = new SysUser();
//        sysUser.setName("李六");
//        iSysUserService.save(sysUser);

        List<SysUser> sysUsers = iSysUserService.findAll();
        log.info("=====================================================");
        log.info("sysUsers:{}",JSON.toJSON(sysUsers));

        for (SysUser po:sysUsers){
            po.setEmail("12356789@qq.com");
            iSysUserService.updateById(po);
        }
    }

}
