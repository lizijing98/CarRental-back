package com.carrental.info.service.impl;

import java.util.List;
import com.carrental.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carrental.info.mapper.BsnCarsMapper;
import com.carrental.info.domain.BsnCars;
import com.carrental.info.service.IBsnCarsService;

/**
 * 车辆信息Service业务层处理
 * 
 * @author carrental
 * @date 2022-10-26
 */
@Service
public class BsnCarsServiceImpl implements IBsnCarsService 
{
    @Autowired
    private BsnCarsMapper bsnCarsMapper;

    /**
     * 查询车辆信息
     * 
     * @param carId 车辆信息主键
     * @return 车辆信息
     */
    @Override
    public BsnCars selectBsnCarsByCarId(Long carId)
    {
        return bsnCarsMapper.selectBsnCarsByCarId(carId);
    }

    /**
     * 查询车辆信息列表
     * 
     * @param bsnCars 车辆信息
     * @return 车辆信息
     */
    @Override
    public List<BsnCars> selectBsnCarsList(BsnCars bsnCars)
    {
        return bsnCarsMapper.selectBsnCarsList(bsnCars);
    }

    /**
     * 新增车辆信息
     * 
     * @param bsnCars 车辆信息
     * @return 结果
     */
    @Override
    public int insertBsnCars(BsnCars bsnCars)
    {
        bsnCars.setCreateTime(DateUtils.getNowDate());
        return bsnCarsMapper.insertBsnCars(bsnCars);
    }

    /**
     * 修改车辆信息
     * 
     * @param bsnCars 车辆信息
     * @return 结果
     */
    @Override
    public int updateBsnCars(BsnCars bsnCars)
    {
        bsnCars.setUpdateTime(DateUtils.getNowDate());
        return bsnCarsMapper.updateBsnCars(bsnCars);
    }

    /**
     * 批量删除车辆信息
     * 
     * @param carIds 需要删除的车辆信息主键
     * @return 结果
     */
    @Override
    public int deleteBsnCarsByCarIds(Long[] carIds)
    {
        return bsnCarsMapper.deleteBsnCarsByCarIds(carIds);
    }

    /**
     * 删除车辆信息信息
     * 
     * @param carId 车辆信息主键
     * @return 结果
     */
    @Override
    public int deleteBsnCarsByCarId(Long carId)
    {
        return bsnCarsMapper.deleteBsnCarsByCarId(carId);
    }
}
