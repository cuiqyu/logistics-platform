package com.limpid.logistics.communication.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 物流信息对象
 *
 * @author cuiqiongyu
 * @date 2020/11/23 10:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogisticsInfoVo implements Serializable {

    /**
     * 运单号
     */
    private String waybillNumber;
    /**
     * 运单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date recordDate;
    /**
     * 运单状态记录
     */
    private String recordStatusStr;
    /**
     * 备注
     */
    private String remarks;

}
