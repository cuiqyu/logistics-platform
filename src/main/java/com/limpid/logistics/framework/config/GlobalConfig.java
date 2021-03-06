package com.limpid.logistics.framework.config;

import com.limpid.logistics.framework.annotation.EnableGlobalHandler;
import org.springframework.context.annotation.Configuration;

/**
 * 全局处理配置
 *
 * @auther cuiqiongyu
 * @create 2020/5/20 15:35
 */
@Configuration
public class GlobalConfig {

    @EnableGlobalHandler(handlerException = true, handlerReturnValue = true)
    public static class GlobalHandler {
    }

}
