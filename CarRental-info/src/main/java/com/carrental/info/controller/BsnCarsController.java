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
import com.carrental.info.domain.BsnCars;
import com.carrental.info.service.IBsnCarsService;
import com.carrental.common.utils.poi.ExcelUtil;
import com.carrental.common.core.page.TableDataInfo;

/**
 * 车辆信息Controller
 * 
 * @author carrental
 * @date 2022-10-25
 */
@RestController
@RequestMapping("/info/cars")
public class BsnCarsController extends BaseController
{
    @Autowired
    private IBsnCarsService bsnCarsService;

    /**
     * 查询车辆信息列表
     */
    @PreAuthorize("@ss.hasPermi('info:cars:list')")
    @GetMapping("/list")
    public TableDataInfo list(BsnCars bsnCars)
    {
        startPage();
        List<BsnCars> list = bsnCarsService.selectBsnCarsList(bsnCars);
        return getDataTable(list);
    }

    /**
     * 导出车辆信息列表
     */
    @PreAuthorize("@ss.hasPermi('info:cars:export')")
    @Log(title = "车辆信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BsnCars bsnCars)
    {
        List<BsnCars> list = bsnCarsService.selectBsnCarsList(bsnCars);
        ExcelUtil<BsnCars> util = new ExcelUtil<BsnCars>(BsnCars.class);
        util.exportExcel(response, list, "车辆信息数据");
    }

    /**
     * 获取车辆信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('info:cars:query')")
    @GetMapping(value = "/{carId}")
    public AjaxResult getInfo(@PathVariable("carId") Long carId)
    {
        return AjaxResult.success(bsnCarsService.selectBsnCarsByCarId(carId));
    }

    /**
     * 新增车辆信息
     */
    @PreAuthorize("@ss.hasPermi('info:cars:add')")
    @Log(title = "车辆信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BsnCars bsnCars)
    {
        return toAjax(bsnCarsService.insertBsnCars(bsnCars));
    }

    /**
     * 修改车辆信息
     */
    @PreAuthorize("@ss.hasPermi('info:cars:edit')")
    @Log(title = "车辆信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BsnCars bsnCars)
    {
        return toAjax(bsnCarsService.updateBsnCars(bsnCars));
    }

    /**
     * 删除车辆信息
     */
    @PreAuthorize("@ss.hasPermi('info:cars:remove')")
    @Log(title = "车辆信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{carIds}")
    public AjaxResult remove(@PathVariable Long[] carIds)
    {
        return toAjax(bsnCarsService.deleteBsnCarsByCarIds(carIds));
    }
}
