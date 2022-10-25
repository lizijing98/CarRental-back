package com.carrental.info.service.impl;

import java.util.List;
import com.carrental.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carrental.info.mapper.BsnStoresMapper;
import com.carrental.info.domain.BsnStores;
import com.carrental.info.service.IBsnStoresService;

/**
 * 门店信息Service业务层处理
 * 
 * @author Li Zijing
 * @date 2022-10-26
 */
@Service
public class BsnStoresServiceImpl implements IBsnStoresService 
{
    @Autowired
    private BsnStoresMapper bsnStoresMapper;

    /**
     * 查询门店信息
     * 
     * @param storeId 门店信息主键
     * @return 门店信息
     */
    @Override
    public BsnStores selectBsnStoresByStoreId(Long storeId)
    {
        return bsnStoresMapper.selectBsnStoresByStoreId(storeId);
    }

    /**
     * 查询门店信息列表
     * 
     * @param bsnStores 门店信息
     * @return 门店信息
     */
    @Override
    public List<BsnStores> selectBsnStoresList(BsnStores bsnStores)
    {
        return bsnStoresMapper.selectBsnStoresList(bsnStores);
    }

    /**
     * 新增门店信息
     * 
     * @param bsnStores 门店信息
     * @return 结果
     */
    @Override
    public int insertBsnStores(BsnStores bsnStores)
    {
        bsnStores.setCreateTime(DateUtils.getNowDate());
        return bsnStoresMapper.insertBsnStores(bsnStores);
    }

    /**
     * 修改门店信息
     * 
     * @param bsnStores 门店信息
     * @return 结果
     */
    @Override
    public int updateBsnStores(BsnStores bsnStores)
    {
        bsnStores.setUpdateTime(DateUtils.getNowDate());
        return bsnStoresMapper.updateBsnStores(bsnStores);
    }

    /**
     * 批量删除门店信息
     * 
     * @param storeIds 需要删除的门店信息主键
     * @return 结果
     */
    @Override
    public int deleteBsnStoresByStoreIds(Long[] storeIds)
    {
        return bsnStoresMapper.deleteBsnStoresByStoreIds(storeIds);
    }

    /**
     * 删除门店信息信息
     * 
     * @param storeId 门店信息主键
     * @return 结果
     */
    @Override
    public int deleteBsnStoresByStoreId(Long storeId)
    {
        return bsnStoresMapper.deleteBsnStoresByStoreId(storeId);
    }
}
