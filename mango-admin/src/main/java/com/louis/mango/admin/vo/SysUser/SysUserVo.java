package com.louis.mango.admin.vo.SysUser;

import com.louis.mango.admin.model.SysUser;
import lombok.Data;

/**
 * SysUser 的 vo
 *
 * @quthor haMi
 * @date2019/11/2
 */
@Data
public class SysUserVo extends SysUser {
    /**
     * 机构名称
     */
    private String deptName;

    /**
     * 角色
     */
    private String roleNames;
}
