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
import com.limpid.logistics.project.logistics.info.domain.TExpressDeliveryInfo;
import com.limpid.logistics.project.logistics.info.service.ITExpressDeliveryInfoService;
import com.limpid.logistics.framework.web.controller.BaseController;
import com.limpid.logistics.framework.web.domain.AjaxResult;
import com.limpid.logistics.common.utils.poi.ExcelUtil;
import com.limpid.logistics.framework.web.page.TableDataInfo;

/**
 * 寄件Controller
 * 
 * @author limpid
 * @date 2020-12-07
 */
@Controller
@RequestMapping("/logistics/info/expressDeliveryInfo")
public class TExpressDeliveryInfoController extends BaseController
{
    private String prefix = "logistics/expressDelivery";

    @Autowired
    private ITExpressDeliveryInfoService tExpressDeliveryInfoService;

    @RequiresPermissions("logistics:expressDelivery:view")
    @GetMapping()
    public String ExpressDelivery()
    {
        return prefix + "/expressDeliveryInfo";
    }

    /**
     * 查询寄件列表
     */
    @RequiresPermissions("logistics:expressDelivery:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TExpressDeliveryInfo tExpressDeliveryInfo)
    {
        startPage();
        List<TExpressDeliveryInfo> list = tExpressDeliveryInfoService.selectTExpressDeliveryInfoList(tExpressDeliveryInfo);
        return getDataTable(list);
    }

    /**
     * 导出寄件列表
     */
    @RequiresPermissions("logistics:expressDelivery:export")
    @Log(title = "寄件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TExpressDeliveryInfo tExpressDeliveryInfo)
    {
        List<TExpressDeliveryInfo> list = tExpressDeliveryInfoService.selectTExpressDeliveryInfoList(tExpressDeliveryInfo);
        ExcelUtil<TExpressDeliveryInfo> util = new ExcelUtil<TExpressDeliveryInfo>(TExpressDeliveryInfo.class);
        return util.exportExcel(list, "expressDeliveryInfo");
    }

    /**
     * 新增寄件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存寄件
     */
    @RequiresPermissions("logistics:expressDelivery:add")
    @Log(title = "寄件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TExpressDeliveryInfo tExpressDeliveryInfo)
    {
        return toAjax(tExpressDeliveryInfoService.insertTExpressDeliveryInfo(tExpressDeliveryInfo));
    }

    /**
     * 修改寄件
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TExpressDeliveryInfo tExpressDeliveryInfo = tExpressDeliveryInfoService.selectTExpressDeliveryInfoById(id);
        mmap.put("tExpressDeliveryInfo", tExpressDeliveryInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存寄件
     */
    @RequiresPermissions("logistics:expressDelivery:edit")
    @Log(title = "寄件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TExpressDeliveryInfo tExpressDeliveryInfo)
    {
        return toAjax(tExpressDeliveryInfoService.updateTExpressDeliveryInfo(tExpressDeliveryInfo));
    }

    /**
     * 删除寄件
     */
    @RequiresPermissions("logistics:expressDelivery:remove")
    @Log(title = "寄件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tExpressDeliveryInfoService.deleteTExpressDeliveryInfoByIds(ids));
    }

}
