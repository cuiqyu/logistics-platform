package com.limpid.logistics.project.logistics.info.service.impl;

import java.util.List;
import com.limpid.logistics.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.limpid.logistics.project.logistics.info.mapper.TExpressDeliveryInfoMapper;
import com.limpid.logistics.project.logistics.info.domain.TExpressDeliveryInfo;
import com.limpid.logistics.project.logistics.info.service.ITExpressDeliveryInfoService;
import com.limpid.logistics.common.utils.text.Convert;

/**
 * 寄件Service业务层处理
 * 
 * @author limpid
 * @date 2020-12-07
 */
@Service
public class TExpressDeliveryInfoServiceImpl implements ITExpressDeliveryInfoService 
{
    @Autowired
    private TExpressDeliveryInfoMapper tExpressDeliveryInfoMapper;

    /**
     * 查询寄件
     * 
     * @param id 寄件ID
     * @return 寄件
     */
    @Override
    public TExpressDeliveryInfo selectTExpressDeliveryInfoById(Long id)
    {
        return tExpressDeliveryInfoMapper.selectTExpressDeliveryInfoById(id);
    }

    /**
     * 查询寄件列表
     * 
     * @param tExpressDeliveryInfo 寄件
     * @return 寄件
     */
    @Override
    public List<TExpressDeliveryInfo> selectTExpressDeliveryInfoList(TExpressDeliveryInfo tExpressDeliveryInfo)
    {
        return tExpressDeliveryInfoMapper.selectTExpressDeliveryInfoList(tExpressDeliveryInfo);
    }

    /**
     * 新增寄件
     * 
     * @param tExpressDeliveryInfo 寄件
     * @return 结果
     */
    @Override
    public int insertTExpressDeliveryInfo(TExpressDeliveryInfo tExpressDeliveryInfo)
    {
        tExpressDeliveryInfo.setCreateTime(DateUtils.getNowDate());
        return tExpressDeliveryInfoMapper.insertTExpressDeliveryInfo(tExpressDeliveryInfo);
    }

    /**
     * 修改寄件
     * 
     * @param tExpressDeliveryInfo 寄件
     * @return 结果
     */
    @Override
    public int updateTExpressDeliveryInfo(TExpressDeliveryInfo tExpressDeliveryInfo)
    {
        tExpressDeliveryInfo.setUpdateTime(DateUtils.getNowDate());
        return tExpressDeliveryInfoMapper.updateTExpressDeliveryInfo(tExpressDeliveryInfo);
    }

    /**
     * 删除寄件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTExpressDeliveryInfoByIds(String ids)
    {
        return tExpressDeliveryInfoMapper.deleteTExpressDeliveryInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除寄件信息
     * 
     * @param id 寄件ID
     * @return 结果
     */
    @Override
    public int deleteTExpressDeliveryInfoById(Long id)
    {
        return tExpressDeliveryInfoMapper.deleteTExpressDeliveryInfoById(id);
    }
}
