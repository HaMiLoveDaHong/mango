package com.louis.mango.core.page;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页请求
 *
 * @quthor haMi
 * @date2019/10/19
 */
@Data
public class PageRequest {

    /**
     * 当前页码
     */
    private int PageNum = 1;

    /**
     * 每页数量
     */
    private int pageSize = 10;

    /**
     * 查询参数
     */
    private Map<String, Object> params = new HashMap();

}
