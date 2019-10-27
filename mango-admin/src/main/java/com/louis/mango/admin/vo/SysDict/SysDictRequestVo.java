package com.louis.mango.admin.vo.SysDict;

import com.github.pagehelper.util.StringUtil;
import com.louis.mango.core.page.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @quthor haMi
 * @date2019/10/27
 */
@Data
public class SysDictRequestVo extends PageRequest implements Serializable {
    private static final long serialVersionUID = 720526210732509404L;

    /**
     * 标签字段
     */
    private String lable;

    /**
     * 主键id
     */
    private String id;

    /**
     * 重写getter方法
     * @return
     */
    public String getLable() {
        if (!StringUtil.isEmpty(this.lable)){
            this.lable = this.lable.trim();
        }
        return lable;
    }
}
