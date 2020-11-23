package com.limpid.logistics.project.logistics.info.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.limpid.logistics.common.utils.StringUtils;
import com.limpid.logistics.communication.vo.LogisticsInfoVo;
import com.limpid.logistics.framework.web.service.DictService;
import com.limpid.logistics.project.system.dict.domain.DictData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
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
@Slf4j
public class TLogisticsInfoServiceImpl implements ITLogisticsInfoService {
    @Autowired
    private TLogisticsInfoMapper tLogisticsInfoMapper;

    @Autowired
    private DictService dictService;

    /**
     * 查询物流信息记录
     *
     * @param id 物流信息记录ID
     * @return 物流信息记录
     */
    @Override
    public TLogisticsInfo selectTLogisticsInfoById(Long id) {
        return tLogisticsInfoMapper.selectTLogisticsInfoById(id);
    }

    /**
     * 查询物流信息记录列表
     *
     * @param tLogisticsInfo 物流信息记录
     * @return 物流信息记录
     */
    @Override
    public List<TLogisticsInfo> selectTLogisticsInfoList(TLogisticsInfo tLogisticsInfo) {
        return tLogisticsInfoMapper.selectTLogisticsInfoList(tLogisticsInfo);
    }

    /**
     * 新增物流信息记录
     *
     * @param tLogisticsInfo 物流信息记录
     * @return 结果
     */
    @Override
    public int insertTLogisticsInfo(TLogisticsInfo tLogisticsInfo) {
        return tLogisticsInfoMapper.insertTLogisticsInfo(tLogisticsInfo);
    }

    /**
     * 修改物流信息记录
     *
     * @param tLogisticsInfo 物流信息记录
     * @return 结果
     */
    @Override
    public int updateTLogisticsInfo(TLogisticsInfo tLogisticsInfo) {
        return tLogisticsInfoMapper.updateTLogisticsInfo(tLogisticsInfo);
    }

    /**
     * 删除物流信息记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTLogisticsInfoByIds(String ids) {
        return tLogisticsInfoMapper.deleteTLogisticsInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物流信息记录信息
     *
     * @param id 物流信息记录ID
     * @return 结果
     */
    @Override
    public int deleteTLogisticsInfoById(Long id) {
        return tLogisticsInfoMapper.deleteTLogisticsInfoById(id);
    }

    /**
     * 根据物流单号查询物流记录
     *
     * @param waybillNumber 物流单号
     * @return
     */
    @Override
    public List<LogisticsInfoVo> getWaybillNumber(String waybillNumber) {
        List<LogisticsInfoVo> result = new ArrayList<>();
        if (StringUtils.isEmpty(waybillNumber)) {
            log.error("根据物流单号查询物流记录失败，物流单号不能为空！");
            return result;
        }

        List<TLogisticsInfo> tLogisticsInfos = tLogisticsInfoMapper.getWaybillNumber(waybillNumber);
        if (CollectionUtils.isNotEmpty(tLogisticsInfos)) {
            Map<Integer, String> logisticsStatusDict = getLogisticsStatusDict();
            for (TLogisticsInfo tLogisticsInfo : tLogisticsInfos) {
                String s = logisticsStatusDict.get(tLogisticsInfo.getRecordStatus());
                if (StringUtils.isEmpty(s)) {
                    s = String.valueOf(tLogisticsInfo.getRecordStatus());
                }
                result.add(new LogisticsInfoVo(tLogisticsInfo.getWaybillNumber(), tLogisticsInfo.getRecordDate(), s, tLogisticsInfo.getRemarks()));
            }
        }

        return result;
    }

    /**
     * 获取物流状态字典
     *
     * @return
     */
    private Map<Integer, String> getLogisticsStatusDict() {
        Map<Integer, String> result = new HashMap<>();
        List<DictData> logistics_record_status = dictService.getType("logistics_record_status");
        if (CollectionUtils.isNotEmpty(logistics_record_status)) {
            result = logistics_record_status.stream().collect(Collectors.toMap(d -> Integer.valueOf(d.getDictValue()), DictData::getDictValue, (m1, m2) -> m1));
        }
        return result;
    }

}
