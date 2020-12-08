package com.limpid.logistics.communication.controller;

import com.limpid.logistics.communication.vo.ExpressDeliveryInfoParamVo;
import com.limpid.logistics.framework.annotation.InternalExceptionHandler;
import com.limpid.logistics.framework.annotation.ResponseDataHandler;
import com.limpid.logistics.project.logistics.info.service.ITExpressDeliveryInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对外物流寄件接口
 *
 * @author cuiqiongyu
 * @date 2020/12/8 13:16
 */
@RestController
@RequestMapping("/service/expressDelivery")
@InternalExceptionHandler
@Api(value = "物流记录接口")
public class ApiExpressDeliveryInfoController {

    @Autowired
    private ITExpressDeliveryInfoService itExpressDeliveryInfoService;

    @PostMapping("/mail")
    @ResponseDataHandler
    @ApiOperation(value = "客户寄件", notes = "添加寄件记录")
    // @LogHawkeye
    public String mail(@RequestBody ExpressDeliveryInfoParamVo expressDeliveryInfoParamVo) {
        return itExpressDeliveryInfoService.mail(expressDeliveryInfoParamVo);
    }

}
