package com.limpid.logistics.communication.controller;

import com.limpid.logistics.communication.vo.LogisticsInfoParamVo;
import com.limpid.logistics.communication.vo.LogisticsInfoVo;
import com.limpid.logistics.framework.annotation.InternalExceptionHandler;
import com.limpid.logistics.framework.annotation.ResponseDataHandler;
import com.limpid.logistics.project.logistics.info.service.ITLogisticsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 对外物流记录接口
 *
 * @author cuiqiongyu
 * @date 2020/11/23 10:41
 */
@RestController
@RequestMapping("/service/logisticsinfo")
@InternalExceptionHandler
@Api(value = "物流记录接口")
public class ApiLogisticsInfoController {

    @Autowired
    private ITLogisticsInfoService itLogisticsInfoService;

    @PostMapping("/getBywaybillNumber")
    @ResponseDataHandler
    @ApiOperation(value = "物流记录", notes = "根据物流单号查询物流记录")
    // @LogHawkeye
    public List<LogisticsInfoVo> getBywaybillNumber(@RequestBody LogisticsInfoParamVo logisticsInfoParamVo) {
        return itLogisticsInfoService.getWaybillNumber(logisticsInfoParamVo.getWaybillNumber());
    }

}
