package com.limpid.logistics.project.logistics.info.domain;

import java.util.Date;
import com.limpid.logistics.framework.aspectj.lang.annotation.Excel;
import com.limpid.logistics.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 寄件对象 t_express_delivery_info
 * 
 * @author limpid
 * @date 2020-12-07
 */
public class TExpressDeliveryInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

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
    @Excel(name = "")
    private String mailAddress;

    /** 寄件人邮编 */
    @Excel(name = "寄件人邮编")
    private String mailPostCode;

    /** 寄件日期 */
    @Excel(name = "寄件日期", width = 30, dateFormat = "yyyy-MM-dd")
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

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
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
