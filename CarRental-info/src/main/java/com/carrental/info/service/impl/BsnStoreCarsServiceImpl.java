package com.carrental.info.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carrental.info.mapper.BsnStoreCarsMapper;
import com.carrental.info.domain.BsnStoreCars;
import com.carrental.info.service.IBsnStoreCarsService;

/**
 * 门店车辆分配Service业务层处理
 * 
 * @author Li Zijing
 * @date 2022-10-28
 */
@Service
public class BsnStoreCarsServiceImpl implements IBsnStoreCarsService 
{
    @Autowired
    private BsnStoreCarsMapper bsnStoreCarsMapper;

    /**
     * 查询门店车辆分配
     * 
     * @param storeId 门店车辆分配主键
     * @return 门店车辆分配
     */
    @Override
    public BsnStoreCars selectBsnStoreCarsByStoreId(Long storeId)
    {
        return bsnStoreCarsMapper.selectBsnStoreCarsByStoreId(storeId);
    }

    /**
     * 查询门店车辆分配列表
     * 
     * @param bsnStoreCars 门店车辆分配
     * @return 门店车辆分配
     */
    @Override
    public List<BsnStoreCars> selectBsnStoreCarsList(BsnStoreCars bsnStoreCars)
    {
        return bsnStoreCarsMapper.selectBsnStoreCarsList(bsnStoreCars);
    }

    /**
     * 新增门店车辆分配
     * 
     * @param bsnStoreCars 门店车辆分配
     * @return 结果
     */
    @Override
    public int insertBsnStoreCars(BsnStoreCars bsnStoreCars)
    {
        return bsnStoreCarsMapper.insertBsnStoreCars(bsnStoreCars);
    }

    /**
     * 修改门店车辆分配
     * 
     * @param bsnStoreCars 门店车辆分配
     * @return 结果
     */
    @Override
    public int updateBsnStoreCars(BsnStoreCars bsnStoreCars)
    {
        return bsnStoreCarsMapper.updateBsnStoreCars(bsnStoreCars);
    }

    /**
     * 批量删除门店车辆分配
     * 
     * @param storeIds 需要删除的门店车辆分配主键
     * @return 结果
     */
    @Override
    public int deleteBsnStoreCarsByStoreIds(Long[] storeIds)
    {
        return bsnStoreCarsMapper.deleteBsnStoreCarsByStoreIds(storeIds);
    }

    /**
     * 删除门店车辆分配信息
     * 
     * @param storeId 门店车辆分配主键
     * @return 结果
     */
    @Override
    public int deleteBsnStoreCarsByStoreId(Long storeId)
    {
        return bsnStoreCarsMapper.deleteBsnStoreCarsByStoreId(storeId);
    }
}
