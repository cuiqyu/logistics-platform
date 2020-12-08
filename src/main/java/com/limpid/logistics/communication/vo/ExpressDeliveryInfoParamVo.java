package com.limpid.logistics.communication.vo;

import com.limpid.logistics.framework.aspectj.lang.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

/**
 * 客户寄件对象参数信息
 *
 * @author cuiqiongyu
 * @date 2020/12/8 13:19
 */
@Data
public class ExpressDeliveryInfoParamVo implements Serializable {

    private static final long serialVersionUID = -6275449451937191795L;

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

}
