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
import com.carrental.info.domain.BsnStores;
import com.carrental.info.service.IBsnStoresService;
import com.carrental.common.utils.poi.ExcelUtil;
import com.carrental.common.core.page.TableDataInfo;

/**
 * 门店信息Controller
 * 
 * @author Li Zijing
 * @date 2022-10-26
 */
@RestController
@RequestMapping("/info/stores")
public class BsnStoresController extends BaseController
{
    @Autowired
    private IBsnStoresService bsnStoresService;

    /**
     * 查询门店信息列表
     */
    @PreAuthorize("@ss.hasPermi('info:stores:list')")
    @GetMapping("/list")
    public TableDataInfo list(BsnStores bsnStores)
    {
        startPage();
        List<BsnStores> list = bsnStoresService.selectBsnStoresList(bsnStores);
        return getDataTable(list);
    }

    /**
     * 导出门店信息列表
     */
    @PreAuthorize("@ss.hasPermi('info:stores:export')")
    @Log(title = "门店信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BsnStores bsnStores)
    {
        List<BsnStores> list = bsnStoresService.selectBsnStoresList(bsnStores);
        ExcelUtil<BsnStores> util = new ExcelUtil<BsnStores>(BsnStores.class);
        util.exportExcel(response, list, "门店信息数据");
    }

    /**
     * 获取门店信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('info:stores:query')")
    @GetMapping(value = "/{storeId}")
    public AjaxResult getInfo(@PathVariable("storeId") Long storeId)
    {
        return AjaxResult.success(bsnStoresService.selectBsnStoresByStoreId(storeId));
    }

    /**
     * 新增门店信息
     */
    @PreAuthorize("@ss.hasPermi('info:stores:add')")
    @Log(title = "门店信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BsnStores bsnStores)
    {
        return toAjax(bsnStoresService.insertBsnStores(bsnStores));
    }

    /**
     * 修改门店信息
     */
    @PreAuthorize("@ss.hasPermi('info:stores:edit')")
    @Log(title = "门店信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BsnStores bsnStores)
    {
        return toAjax(bsnStoresService.updateBsnStores(bsnStores));
    }

    /**
     * 删除门店信息
     */
    @PreAuthorize("@ss.hasPermi('info:stores:remove')")
    @Log(title = "门店信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{storeIds}")
    public AjaxResult remove(@PathVariable Long[] storeIds)
    {
        return toAjax(bsnStoresService.deleteBsnStoresByStoreIds(storeIds));
    }
}
