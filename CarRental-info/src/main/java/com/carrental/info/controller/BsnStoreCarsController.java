package com.carrental.info.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.carrental.common.annotation.Log;
import com.carrental.common.core.controller.BaseController;
import com.carrental.common.core.domain.AjaxResult;
import com.carrental.common.enums.BusinessType;
import com.carrental.info.domain.BsnStoreCars;
import com.carrental.info.service.IBsnStoreCarsService;
import com.carrental.common.utils.poi.ExcelUtil;
import com.carrental.common.core.page.TableDataInfo;

/**
 * 门店车辆分配Controller
 * 
 * @author Li Zijing
 * @date 2022-10-28
 */
@RestController
@RequestMapping("/info/setrelation")
public class BsnStoreCarsController extends BaseController
{
    @Autowired
    private IBsnStoreCarsService bsnStoreCarsService;

    /**
     * 查询门店车辆分配列表
     */
    @PreAuthorize("@ss.hasPermi('info:setrelation:list')")
    @GetMapping("/list")
    public TableDataInfo list(BsnStoreCars bsnStoreCars)
    {
        startPage();
        List<BsnStoreCars> list = bsnStoreCarsService.selectBsnStoreCarsList(bsnStoreCars);
        return getDataTable(list);
    }

    /**
     * 导出门店车辆分配列表
     */
    @PreAuthorize("@ss.hasPermi('info:setrelation:export')")
    @Log(title = "门店车辆分配", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BsnStoreCars bsnStoreCars)
    {
        List<BsnStoreCars> list = bsnStoreCarsService.selectBsnStoreCarsList(bsnStoreCars);
        ExcelUtil<BsnStoreCars> util = new ExcelUtil<BsnStoreCars>(BsnStoreCars.class);
        util.exportExcel(response, list, "门店车辆分配数据");
    }

    /**
     * 获取门店车辆分配详细信息
     */
    @PreAuthorize("@ss.hasPermi('info:setrelation:query')")
    @GetMapping(value = "/{storeId}")
    public AjaxResult getInfo(@PathVariable("storeId") Long storeId)
    {
        return AjaxResult.success(bsnStoreCarsService.selectBsnStoreCarsByStoreId(storeId));
    }

    /**
     * 新增门店车辆分配
     */
    @PreAuthorize("@ss.hasPermi('info:setrelation:add')")
    @Log(title = "门店车辆分配", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BsnStoreCars bsnStoreCars)
    {
        return toAjax(bsnStoreCarsService.insertBsnStoreCars(bsnStoreCars));
    }

    /**
     * 修改门店车辆分配
     */
    @PreAuthorize("@ss.hasPermi('info:setrelation:edit')")
    @Log(title = "门店车辆分配", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BsnStoreCars bsnStoreCars)
    {
        return toAjax(bsnStoreCarsService.updateBsnStoreCars(bsnStoreCars));
    }

    /**
     * 删除门店车辆分配
     */
    @PreAuthorize("@ss.hasPermi('info:setrelation:remove')")
    @Log(title = "门店车辆分配", businessType = BusinessType.DELETE)
	@DeleteMapping("/{storeIds}")
    public AjaxResult remove(@PathVariable Long[] storeIds)
    {
        return toAjax(bsnStoreCarsService.deleteBsnStoreCarsByStoreIds(storeIds));
    }
}
