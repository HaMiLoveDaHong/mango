package com.louis.mango.admin.service.impl;

import com.louis.mango.admin.model.SysUser;
import com.louis.mango.admin.dao.SysUserMapper;
import com.louis.mango.admin.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.louis.mango.admin.vo.SysUser.SysUserVo;
import com.louis.mango.common.utils.DateTimeUtils;
import com.louis.mango.common.utils.PoiUtils;
import com.louis.mango.core.page.MybatisPageHelper;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户管理 服务实现类
 * </p>
 *
 * @author hami
 * @since 2019-10-11
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest,sysUserMapper);
    }

    @Override
    public File createUserExcelFile(PageRequest pageRequest) {
        PageResult pageResult =MybatisPageHelper.findPage(pageRequest,sysUserMapper,"findVoPage");
        return createUserExcelFile(pageResult.getContent());
    }

    public static File createUserExcelFile(List<?> records){
        if (ObjectUtils.isEmpty(records)){
            records = new ArrayList();
        }

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row0 = sheet.createRow(0);
        int clumnIndex = 0;
        row0.createCell(clumnIndex).setCellValue("No");
        row0.createCell(++clumnIndex).setCellValue("ID");
        row0.createCell(++clumnIndex).setCellValue("用户名称");
        row0.createCell(++clumnIndex).setCellValue("昵称");
        row0.createCell(++clumnIndex).setCellValue("机构");
        row0.createCell(++clumnIndex).setCellValue("角色");
        row0.createCell(++clumnIndex).setCellValue("邮箱");
        row0.createCell(++clumnIndex).setCellValue("手机号");
        row0.createCell(++clumnIndex).setCellValue("状态");
        row0.createCell(++clumnIndex).setCellValue("头像");
        row0.createCell(++clumnIndex).setCellValue("创建人");
        row0.createCell(++clumnIndex).setCellValue("创建时间");
        row0.createCell(++clumnIndex).setCellValue("最后更新人");
        row0.createCell(++clumnIndex).setCellValue("最后更新时间");

        for (int i =0;i < records.size() ; i++){
            SysUserVo user = (SysUserVo) records.get(i);
            Row row = sheet.createRow(i+1);
            for (int j=0;j<clumnIndex +1;j++){
                row.createCell(j);
            }
            clumnIndex = 0;
            row.getCell(clumnIndex).setCellValue(i+1);
            row.getCell(++clumnIndex).setCellValue(user.getId());
            row.getCell(++clumnIndex).setCellValue(user.getName());
            row.getCell(++clumnIndex).setCellValue(user.getNickName());
            row.getCell(++clumnIndex).setCellValue(user.getDeptName());
            row.getCell(++clumnIndex).setCellValue(user.getRoleNames());
            row.getCell(++clumnIndex).setCellValue(user.getEmail());
            row.getCell(++clumnIndex).setCellValue(user.getStatus());
            row.getCell(++clumnIndex).setCellValue(user.getAvatar());
            row.getCell(++clumnIndex).setCellValue(user.getCreateBy());
            row.getCell(++clumnIndex).setCellValue(DateTimeUtils.str(user.getCreateTime()));
            row.getCell(++clumnIndex).setCellValue(user.getLastUpdateBy());
            row.getCell(++clumnIndex).setCellValue(DateTimeUtils.str(user.getLastUpdateTime()));
        }
        return PoiUtils.createExcelFile(workbook,"download_user");
    }
}
