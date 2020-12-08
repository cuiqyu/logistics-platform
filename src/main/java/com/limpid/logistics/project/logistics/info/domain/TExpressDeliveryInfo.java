package com.limpid.logistics.project.logistics.info.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.limpid.logistics.framework.aspectj.lang.annotation.Excel;
import com.limpid.logistics.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.StringUtils;

/**
 * 寄件对象 t_express_delivery_info
 * 
 * @author limpid
 * @date 2020-12-07
 */
public class TExpressDeliveryInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private String id;

    /** 寄件人姓名 */
    @Excel(name = "寄件人姓名")
    private String mailName;

    /** 寄件人性别 */
    @Excel(name = "寄件人性别")
    private Integer mailSex;

    /** 寄件人微信id */
    @Excel(name = "寄件人微信id")
    private String mailWxid;

    /**  */
    @Excel(name = "寄件人地址")
    private String mailAddress;

    /** 寄件人邮编 */
    @Excel(name = "寄件人邮编")
    private String mailPostCode;

    /** 寄件日期 */
    @Excel(name = "寄件日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mailDate;

    /** 预估行李数量 */
    @Excel(name = "预估行李数量")
    private Long bagsNum;

    /** 收件人地址 */
    @Excel(name = "收件人地址")
    private String receiptAddress;

    /** 收件人邮编 */
    @Excel(name = "收件人邮编")
    private String receiptPostCode;

    /** 收件人电话信息 */
    @Excel(name = "收件人电话信息")
    private String receiptTellphone;

    /** 收件人身份证号码 */
    @Excel(name = "收件人身份证号码")
    private String receiptIdcard;

    /** 收件人姓名 */
    @Excel(name = "收件人姓名")
    private String receiptName;

    /** 运单号 */
    @Excel(name = "运单号")
    private String waybillNumber;

    /**
     * 发货状态
     */
    @Excel(name = "发货状态")
    private Boolean shipmentStatus;
    private Boolean shipmentStatusParam;

    public Boolean getShipmentStatus() {
        if (StringUtils.isEmpty(waybillNumber)) {
            return false;
        }
        return true;
    }

    public void setShipmentStatus(Boolean shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public Boolean getShipmentStatusParam() {
        return shipmentStatusParam;
    }

    public void setShipmentStatusParam(Boolean shipmentStatusParam) {
        this.shipmentStatusParam = shipmentStatusParam;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setMailName(String mailName)
    {
        this.mailName = mailName;
    }

    public String getMailName()
    {
        return mailName;
    }
    public void setMailSex(Integer mailSex)
    {
        this.mailSex = mailSex;
    }

    public Integer getMailSex()
    {
        return mailSex;
    }
    public void setMailWxid(String mailWxid)
    {
        this.mailWxid = mailWxid;
    }

    public String getMailWxid()
    {
        return mailWxid;
    }
    public void setMailAddress(String mailAddress)
    {
        this.mailAddress = mailAddress;
    }

    public String getMailAddress()
    {
        return mailAddress;
    }
    public void setMailPostCode(String mailPostCode)
    {
        this.mailPostCode = mailPostCode;
    }

    public String getMailPostCode()
    {
        return mailPostCode;
    }
    public void setMailDate(Date mailDate)
    {
        this.mailDate = mailDate;
    }

    public Date getMailDate()
    {
        return mailDate;
    }
    public void setBagsNum(Long bagsNum)
    {
        this.bagsNum = bagsNum;
    }

    public Long getBagsNum()
    {
        return bagsNum;
    }
    public void setReceiptAddress(String receiptAddress)
    {
        this.receiptAddress = receiptAddress;
    }

    public String getReceiptAddress()
    {
        return receiptAddress;
    }
    public void setReceiptPostCode(String receiptPostCode)
    {
        this.receiptPostCode = receiptPostCode;
    }

    public String getReceiptPostCode()
    {
        return receiptPostCode;
    }
    public void setReceiptTellphone(String receiptTellphone)
    {
        this.receiptTellphone = receiptTellphone;
    }

    public String getReceiptTellphone()
    {
        return receiptTellphone;
    }
    public void setReceiptIdcard(String receiptIdcard)
    {
        this.receiptIdcard = receiptIdcard;
    }

    public String getReceiptIdcard()
    {
        return receiptIdcard;
    }
    public void setReceiptName(String receiptName)
    {
        this.receiptName = receiptName;
    }

    public String getReceiptName()
    {
        return receiptName;
    }
    public void setWaybillNumber(String waybillNumber)
    {
        this.waybillNumber = waybillNumber;
    }

    public String getWaybillNumber()
    {
        return waybillNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mailName", getMailName())
            .append("mailSex", getMailSex())
            .append("mailWxid", getMailWxid())
            .append("mailAddress", getMailAddress())
            .append("mailPostCode", getMailPostCode())
            .append("mailDate", getMailDate())
            .append("bagsNum", getBagsNum())
            .append("receiptAddress", getReceiptAddress())
            .append("receiptPostCode", getReceiptPostCode())
            .append("receiptTellphone", getReceiptTellphone())
            .append("receiptIdcard", getReceiptIdcard())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("receiptName", getReceiptName())
            .append("waybillNumber", getWaybillNumber())
            .toString();
    }
}
