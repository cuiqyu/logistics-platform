package com.limpid.logistics.project.logistics.info.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.limpid.logistics.project.logistics.info.mapper.TLogisticsInfoMapper;
import com.limpid.logistics.project.logistics.info.domain.TLogisticsInfo;
import com.limpid.logistics.project.logistics.info.service.ITLogisticsInfoService;
import com.limpid.logistics.common.utils.text.Convert;

/**
 * 物流信息记录Service业务层处理
 * 
 * @author limpid
 * @date 2020-11-22
 */
@Service
public class TLogisticsInfoServiceImpl implements ITLogisticsInfoService 
{
    @Autowired
    private TLogisticsInfoMapper tLogisticsInfoMapper;

    /**
     * 查询物流信息记录
     * 
     * @param id 物流信息记录ID
     * @return 物流信息记录
     */
    @Override
    public TLogisticsInfo selectTLogisticsInfoById(Long id)
    {
        return tLogisticsInfoMapper.selectTLogisticsInfoById(id);
    }

    /**
     * 查询物流信息记录列表
     * 
     * @param tLogisticsInfo 物流信息记录
     * @return 物流信息记录
     */
    @Override
    public List<TLogisticsInfo> selectTLogisticsInfoList(TLogisticsInfo tLogisticsInfo)
    {
        return tLogisticsInfoMapper.selectTLogisticsInfoList(tLogisticsInfo);
    }

    /**
     * 新增物流信息记录
     * 
     * @param tLogisticsInfo 物流信息记录
     * @return 结果
     */
    @Override
    public int insertTLogisticsInfo(TLogisticsInfo tLogisticsInfo)
    {
        return tLogisticsInfoMapper.insertTLogisticsInfo(tLogisticsInfo);
    }

    /**
     * 修改物流信息记录
     * 
     * @param tLogisticsInfo 物流信息记录
     * @return 结果
     */
    @Override
    public int updateTLogisticsInfo(TLogisticsInfo tLogisticsInfo)
    {
        return tLogisticsInfoMapper.updateTLogisticsInfo(tLogisticsInfo);
    }

    /**
     * 删除物流信息记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTLogisticsInfoByIds(String ids)
    {
        return tLogisticsInfoMapper.deleteTLogisticsInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物流信息记录信息
     * 
     * @param id 物流信息记录ID
     * @return 结果
     */
    @Override
    public int deleteTLogisticsInfoById(Long id)
    {
        return tLogisticsInfoMapper.deleteTLogisticsInfoById(id);
    }
}
