package com.limpid.logistics.project.logistics.info.mapper;

import java.util.List;
import com.limpid.logistics.project.logistics.info.domain.TExpressDeliveryInfo;

/**
 * 寄件Mapper接口
 * 
 * @author limpid
 * @date 2020-12-07
 */
public interface TExpressDeliveryInfoMapper 
{
    /**
     * 查询寄件
     * 
     * @param id 寄件ID
     * @return 寄件
     */
    public TExpressDeliveryInfo selectTExpressDeliveryInfoById(Long id);

    /**
     * 查询寄件列表
     * 
     * @param tExpressDeliveryInfo 寄件
     * @return 寄件集合
     */
    public List<TExpressDeliveryInfo> selectTExpressDeliveryInfoList(TExpressDeliveryInfo tExpressDeliveryInfo);

    /**
     * 新增寄件
     * 
     * @param tExpressDeliveryInfo 寄件
     * @return 结果
     */
    public int insertTExpressDeliveryInfo(TExpressDeliveryInfo tExpressDeliveryInfo);

    /**
     * 修改寄件
     * 
     * @param tExpressDeliveryInfo 寄件
     * @return 结果
     */
    public int updateTExpressDeliveryInfo(TExpressDeliveryInfo tExpressDeliveryInfo);

    /**
     * 删除寄件
     * 
     * @param id 寄件ID
     * @return 结果
     */
    public int deleteTExpressDeliveryInfoById(Long id);

    /**
     * 批量删除寄件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTExpressDeliveryInfoByIds(String[] ids);
}
