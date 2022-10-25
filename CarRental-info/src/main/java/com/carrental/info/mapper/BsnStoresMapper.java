package com.carrental.info.mapper;

import java.util.List;
import com.carrental.info.domain.BsnStores;

/**
 * 门店信息Mapper接口
 * 
 * @author Li Zijing
 * @date 2022-10-26
 */
public interface BsnStoresMapper 
{
    /**
     * 查询门店信息
     * 
     * @param storeId 门店信息主键
     * @return 门店信息
     */
    public BsnStores selectBsnStoresByStoreId(Long storeId);

    /**
     * 查询门店信息列表
     * 
     * @param bsnStores 门店信息
     * @return 门店信息集合
     */
    public List<BsnStores> selectBsnStoresList(BsnStores bsnStores);

    /**
     * 新增门店信息
     * 
     * @param bsnStores 门店信息
     * @return 结果
     */
    public int insertBsnStores(BsnStores bsnStores);

    /**
     * 修改门店信息
     * 
     * @param bsnStores 门店信息
     * @return 结果
     */
    public int updateBsnStores(BsnStores bsnStores);

    /**
     * 删除门店信息
     * 
     * @param storeId 门店信息主键
     * @return 结果
     */
    public int deleteBsnStoresByStoreId(Long storeId);

    /**
     * 批量删除门店信息
     * 
     * @param storeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBsnStoresByStoreIds(Long[] storeIds);
}
