package com.limpid.logistics.project.logistics.info.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.limpid.logistics.framework.aspectj.lang.annotation.Excel;
import com.limpid.logistics.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 物流信息记录对象 t_logistics_info
 * 
 * @author limpid
 * @date 2020-11-22
 */
public class TLogisticsInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键记录id */
    private Long id;

    /** 运单号 */
    @Excel(name = "运单号")
    private String waybillNumber;

    /** 物流日期 */
    @Excel(name = "物流日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordDate;

    /** 运单状态枚举 */
    @Excel(name = "运单状态枚举")
    private Integer recordStatus;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setWaybillNumber(String waybillNumber)
    {
        this.waybillNumber = waybillNumber;
    }

    public String getWaybillNumber()
    {
        return waybillNumber;
    }
    public void setRecordDate(Date recordDate)
    {
        this.recordDate = recordDate;
    }

    public Date getRecordDate()
    {
        return recordDate;
    }
    public void setRecordStatus(Integer recordStatus)
    {
        this.recordStatus = recordStatus;
    }

    public Integer getRecordStatus()
    {
        return recordStatus;
    }
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRemarks()
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("waybillNumber", getWaybillNumber())
            .append("recordDate", getRecordDate())
            .append("recordStatus", getRecordStatus())
            .append("remarks", getRemarks())
            .toString();
    }
}
