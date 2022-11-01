package com.carrental.info.service;

import java.util.List;
import com.carrental.info.domain.BsnStoreCars;

/**
 * 门店车辆分配Service接口
 * 
 * @author Li Zijing
 * @date 2022-10-28
 */
public interface IBsnStoreCarsService 
{
    /**
     * 查询门店车辆分配
     * 
     * @param storeId 门店车辆分配主键
     * @return 门店车辆分配
     */
    public BsnStoreCars selectBsnStoreCarsByStoreId(Long storeId);

    /**
     * 查询门店车辆分配列表
     * 
     * @param bsnStoreCars 门店车辆分配
     * @return 门店车辆分配集合
     */
    public List<BsnStoreCars> selectBsnStoreCarsList(BsnStoreCars bsnStoreCars);

    /**
     * 新增门店车辆分配
     * 
     * @param bsnStoreCars 门店车辆分配
     * @return 结果
     */
    public int insertBsnStoreCars(BsnStoreCars bsnStoreCars);

    /**
     * 修改门店车辆分配
     * 
     * @param bsnStoreCars 门店车辆分配
     * @return 结果
     */
    public int updateBsnStoreCars(BsnStoreCars bsnStoreCars);

    /**
     * 批量删除门店车辆分配
     * 
     * @param storeIds 需要删除的门店车辆分配主键集合
     * @return 结果
     */
    public int deleteBsnStoreCarsByStoreIds(Long[] storeIds);

    /**
     * 删除门店车辆分配信息
     * 
     * @param storeId 门店车辆分配主键
     * @return 结果
     */
    public int deleteBsnStoreCarsByStoreId(Long storeId);
}
