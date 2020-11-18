package com.limpid.logistics.common.global;

import com.limpid.logistics.framework.advice.GlobalInternalExceptionHandler;
import org.springframework.context.annotation.Bean;

/**
 * 全局异常处理注射工厂
 *
 * @auther cuiqiongyu
 * @create 2020/5/20 15:04
 */
public class GlobalExceptionHandlerInjectionFactory {

    @Bean
    public GlobalInternalExceptionHandler initGlobalInternalExceptionHandler() {
        return new GlobalInternalExceptionHandler();
    }

}
