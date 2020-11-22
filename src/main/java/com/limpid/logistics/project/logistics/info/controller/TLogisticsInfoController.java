package com.limpid.logistics.project.logistics.info.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.limpid.logistics.framework.aspectj.lang.annotation.Log;
import com.limpid.logistics.framework.aspectj.lang.enums.BusinessType;
import com.limpid.logistics.project.logistics.info.domain.TLogisticsInfo;
import com.limpid.logistics.project.logistics.info.service.ITLogisticsInfoService;
import com.limpid.logistics.framework.web.controller.BaseController;
import com.limpid.logistics.framework.web.domain.AjaxResult;
import com.limpid.logistics.common.utils.poi.ExcelUtil;
import com.limpid.logistics.framework.web.page.TableDataInfo;

/**
 * 物流信息记录Controller
 * 
 * @author limpid
 * @date 2020-11-22
 */
@Controller
@RequestMapping("/logistics/info/LogisticsRecord")
public class TLogisticsInfoController extends BaseController
{
    private String prefix = "logistics/info";

    @Autowired
    private ITLogisticsInfoService tLogisticsInfoService;

    @RequiresPermissions("logistics:info:view")
    @GetMapping()
    public String LogisticsRecord()
    {
        return prefix + "/logisticsRecord";
    }

    /**
     * 查询物流信息记录列表
     */
    @RequiresPermissions("logistics:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TLogisticsInfo tLogisticsInfo)
    {
        startPage();
        List<TLogisticsInfo> list = tLogisticsInfoService.selectTLogisticsInfoList(tLogisticsInfo);
        return getDataTable(list);
    }

    /**
     * 导出物流信息记录列表
     */
    @RequiresPermissions("logistics:info:export")
    @Log(title = "物流信息记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TLogisticsInfo tLogisticsInfo)
    {
        List<TLogisticsInfo> list = tLogisticsInfoService.selectTLogisticsInfoList(tLogisticsInfo);
        ExcelUtil<TLogisticsInfo> util = new ExcelUtil<TLogisticsInfo>(TLogisticsInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增物流信息记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物流信息记录
     */
    @RequiresPermissions("logistics:info:add")
    @Log(title = "物流信息记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TLogisticsInfo tLogisticsInfo)
    {
        return toAjax(tLogisticsInfoService.insertTLogisticsInfo(tLogisticsInfo));
    }

    /**
     * 修改物流信息记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TLogisticsInfo tLogisticsInfo = tLogisticsInfoService.selectTLogisticsInfoById(id);
        mmap.put("tLogisticsInfo", tLogisticsInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存物流信息记录
     */
    @RequiresPermissions("logistics:info:edit")
    @Log(title = "物流信息记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TLogisticsInfo tLogisticsInfo)
    {
        return toAjax(tLogisticsInfoService.updateTLogisticsInfo(tLogisticsInfo));
    }

    /**
     * 删除物流信息记录
     */
    @RequiresPermissions("logistics:info:remove")
    @Log(title = "物流信息记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tLogisticsInfoService.deleteTLogisticsInfoByIds(ids));
    }
}
