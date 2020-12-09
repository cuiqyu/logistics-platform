package com.limpid.logistics.project.logistics.info.service.impl;

import com.limpid.logistics.common.exception.CustomException;
import com.limpid.logistics.common.utils.CustomExceptionAssert;
import com.limpid.logistics.common.utils.text.Convert;
import com.limpid.logistics.communication.vo.ExpressDeliveryInfoParamVo;
import com.limpid.logistics.project.logistics.info.domain.TExpressDeliveryInfo;
import com.limpid.logistics.project.logistics.info.mapper.TExpressDeliveryInfoMapper;
import com.limpid.logistics.project.logistics.info.service.ITExpressDeliveryInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 寄件Service业务层处理
 *
 * @author limpid
 * @date 2020-12-07
 */
@Service
@Slf4j
public class TExpressDeliveryInfoServiceImpl implements ITExpressDeliveryInfoService {
    @Autowired
    private TExpressDeliveryInfoMapper tExpressDeliveryInfoMapper;

    /**
     * 查询寄件
     *
     * @param id 寄件ID
     * @return 寄件
     */
    @Override
    public TExpressDeliveryInfo selectTExpressDeliveryInfoById(String id) {
        return tExpressDeliveryInfoMapper.selectTExpressDeliveryInfoById(id);
    }

    /**
     * 查询寄件列表
     *
     * @param tExpressDeliveryInfo 寄件
     * @return 寄件
     */
    @Override
    public List<TExpressDeliveryInfo> selectTExpressDeliveryInfoList(TExpressDeliveryInfo tExpressDeliveryInfo) {
        return tExpressDeliveryInfoMapper.selectTExpressDeliveryInfoList(tExpressDeliveryInfo);
    }

    /**
     * 新增寄件
     *
     * @param tExpressDeliveryInfo 寄件
     * @return 结果
     */
    @Override
    public int insertTExpressDeliveryInfo(TExpressDeliveryInfo tExpressDeliveryInfo) {
        return tExpressDeliveryInfoMapper.insertTExpressDeliveryInfo(tExpressDeliveryInfo);
    }

    /**
     * 修改寄件
     *
     * @param tExpressDeliveryInfo 寄件
     * @return 结果
     */
    @Override
    public int updateTExpressDeliveryInfo(TExpressDeliveryInfo tExpressDeliveryInfo) {
        return tExpressDeliveryInfoMapper.updateTExpressDeliveryInfo(tExpressDeliveryInfo);
    }

    /**
     * 删除寄件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTExpressDeliveryInfoByIds(String ids) {
        return tExpressDeliveryInfoMapper.deleteTExpressDeliveryInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除寄件信息
     *
     * @param id 寄件ID
     * @return 结果
     */
    @Override
    public int deleteTExpressDeliveryInfoById(String id) {
        return tExpressDeliveryInfoMapper.deleteTExpressDeliveryInfoById(id);
    }

    /**
     * 客户寄件
     *
     * @param expressDeliveryInfoParamVo
     * @return
     */
    @Override
    public String mail(ExpressDeliveryInfoParamVo expressDeliveryInfoParamVo) {
        // 参数校验
        CustomExceptionAssert.notNull(expressDeliveryInfoParamVo);
        CustomExceptionAssert.notEmpty(expressDeliveryInfoParamVo.getMailName(), "寄件人姓名不能为空");
        CustomExceptionAssert.notNull(expressDeliveryInfoParamVo.getMailSex(), "寄件人性别不能为空");
        if (!expressDeliveryInfoParamVo.getMailSex().equals(1) && !expressDeliveryInfoParamVo.getMailSex().equals(0)) {
            throw new CustomException("寄件人性别必须为【0：女，1：男】");
        }
        CustomExceptionAssert.notEmpty(expressDeliveryInfoParamVo.getMailAddress(), "寄件人地址不能为空");
        CustomExceptionAssert.notEmpty(expressDeliveryInfoParamVo.getMailPostCode(), "寄件人邮编不能为空");
        CustomExceptionAssert.notNull(expressDeliveryInfoParamVo.getMailDate(), "寄件日期不能为空");
        CustomExceptionAssert.notNull(expressDeliveryInfoParamVo.getBagsNum(), "寄件包裹数量不能为空");
        CustomExceptionAssert.notEmpty(expressDeliveryInfoParamVo.getReceiptAddress(), "收件人地址不能为空");
        CustomExceptionAssert.notEmpty(expressDeliveryInfoParamVo.getReceiptPostCode(), "收件人邮编不能为空");
        CustomExceptionAssert.notEmpty(expressDeliveryInfoParamVo.getReceiptTellphone(), "收件人电话信息不能为空");
        CustomExceptionAssert.notEmpty(expressDeliveryInfoParamVo.getReceiptTellphone(), "收件人电话信息不能为空");

        // 创建参数
        TExpressDeliveryInfo tExpressDeliveryInfo = new TExpressDeliveryInfo();
        tExpressDeliveryInfo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        tExpressDeliveryInfo.setMailName(expressDeliveryInfoParamVo.getMailName());
        tExpressDeliveryInfo.setMailSex(expressDeliveryInfoParamVo.getMailSex());
        tExpressDeliveryInfo.setMailWxid(expressDeliveryInfoParamVo.getMailWxid());
        tExpressDeliveryInfo.setMailAddress(expressDeliveryInfoParamVo.getMailAddress());
        tExpressDeliveryInfo.setMailPostCode(expressDeliveryInfoParamVo.getMailPostCode());
        tExpressDeliveryInfo.setMailDate(expressDeliveryInfoParamVo.getMailDate());
        tExpressDeliveryInfo.setBagsNum(expressDeliveryInfoParamVo.getBagsNum());
        tExpressDeliveryInfo.setReceiptAddress(expressDeliveryInfoParamVo.getReceiptAddress());
        tExpressDeliveryInfo.setReceiptPostCode(expressDeliveryInfoParamVo.getReceiptPostCode());
        tExpressDeliveryInfo.setReceiptTellphone(expressDeliveryInfoParamVo.getReceiptTellphone());
        tExpressDeliveryInfo.setReceiptIdcard(expressDeliveryInfoParamVo.getReceiptIdcard());
        tExpressDeliveryInfo.setReceiptName(expressDeliveryInfoParamVo.getReceiptName());

        int result = insertTExpressDeliveryInfo(tExpressDeliveryInfo);
        if (result != 1) {
            log.error("新增寄件信息失败，系统异常，请稍后在试~");
            throw new CustomException("系统繁忙，请稍后在试");
        }
        return tExpressDeliveryInfo.getId();
    }

}
