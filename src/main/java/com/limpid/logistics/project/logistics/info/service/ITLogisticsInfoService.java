package com.limpid.logistics.project.logistics.info.service;

import java.util.List;

import com.limpid.logistics.communication.vo.LogisticsInfoVo;
import com.limpid.logistics.project.logistics.info.domain.TLogisticsInfo;

/**
 * 物流信息记录Service接口
 * 
 * @author limpid
 * @date 2020-11-22
 */
public interface ITLogisticsInfoService 
{
    /**
     * 查询物流信息记录
     * 
     * @param id 物流信息记录ID
     * @return 物流信息记录
     */
    public TLogisticsInfo selectTLogisticsInfoById(Long id);

    /**
     * 查询物流信息记录列表
     * 
     * @param tLogisticsInfo 物流信息记录
     * @return 物流信息记录集合
     */
    public List<TLogisticsInfo> selectTLogisticsInfoList(TLogisticsInfo tLogisticsInfo);

    /**
     * 新增物流信息记录
     * 
     * @param tLogisticsInfo 物流信息记录
     * @return 结果
     */
    public int insertTLogisticsInfo(TLogisticsInfo tLogisticsInfo);

    /**
     * 修改物流信息记录
     * 
     * @param tLogisticsInfo 物流信息记录
     * @return 结果
     */
    public int updateTLogisticsInfo(TLogisticsInfo tLogisticsInfo);

    /**
     * 批量删除物流信息记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTLogisticsInfoByIds(String ids);

    /**
     * 删除物流信息记录信息
     * 
     * @param id 物流信息记录ID
     * @return 结果
     */
    public int deleteTLogisticsInfoById(Long id);

    /**
     * 根据物流单号查询物流记录
     * @param waybillNumber 物流单号
     * @return
     */
    List<LogisticsInfoVo> getWaybillNumber(String waybillNumber);

}
