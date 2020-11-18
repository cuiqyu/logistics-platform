package com.limpid.logistics.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回状态定义
 *
 * @auther cuiqiongyu
 * @create 2020/5/20 15:20
 */
public interface GlobalConstant {

    @AllArgsConstructor
    @Getter
    enum ResponseState {
        SUCCESS("0", "成功"),
        PARAM_ERROR("1", "参数错误"),
        FAIL("10", "失败"),
        FREQUENCY_TOO_FAST("30", "操作过于频繁，请稍后在试"),
        BUSINESS_ERROR("50", "业务异常"),
        SYSTEM_ERROR("100", "系统异常");

        private String code;
        private String message;
    }

}
