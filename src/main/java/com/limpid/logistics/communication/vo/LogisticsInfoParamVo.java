package com.limpid.logistics.communication.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 物流信息查询参数对象
 *
 * @author cuiqiongyu
 * @date 2020/11/23 10:47
 */
@Data
public class LogisticsInfoParamVo implements Serializable {

    private static final long serialVersionUID = -528027881088491699L;

    /**
     * 物流单号
     */
    private String waybillNumber;

}
