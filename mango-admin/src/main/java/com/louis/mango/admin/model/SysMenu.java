package com.louis.mango.admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 菜单管理
 * </p>
 *
 * @author hami
 * @since 2019-10-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单ID,一级菜单为0
     */
    private Long parentId;

    /**
     * 菜单 URL，类型:
	1.普通页面（如用户管理，/sys/user）
	2.嵌套完整外部页面，以http(s)开头的连接 
	3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控，iframe:/druid/login.html,iframe:前缀会替换成服务地址)
     */
    private String url;

    /**
     * 授权（多个用逗号分隔，如：sys:user:add,sys:user:deit）
     */
    private String perms;

    /**
     * 类型 0：目录 1：菜单 2：按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String lastUpdateBy;

    /**
     * 更新时间
     */
    private Date lastUpdateTime;

    /**
     * 是否删除 -1:已删除 0:正常
     */
    private Integer delFlag;


}
