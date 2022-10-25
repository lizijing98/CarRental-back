package com.carrental.info.mapper;

import java.util.List;
import com.carrental.info.domain.BsnCars;

/**
 * 车辆信息Mapper接口
 * 
 * @author carrental
 * @date 2022-10-26
 */
public interface BsnCarsMapper 
{
    /**
     * 查询车辆信息
     * 
     * @param carId 车辆信息主键
     * @return 车辆信息
     */
    public BsnCars selectBsnCarsByCarId(Long carId);

    /**
     * 查询车辆信息列表
     * 
     * @param bsnCars 车辆信息
     * @return 车辆信息集合
     */
    public List<BsnCars> selectBsnCarsList(BsnCars bsnCars);

    /**
     * 新增车辆信息
     * 
     * @param bsnCars 车辆信息
     * @return 结果
     */
    public int insertBsnCars(BsnCars bsnCars);

    /**
     * 修改车辆信息
     * 
     * @param bsnCars 车辆信息
     * @return 结果
     */
    public int updateBsnCars(BsnCars bsnCars);

    /**
     * 删除车辆信息
     * 
     * @param carId 车辆信息主键
     * @return 结果
     */
    public int deleteBsnCarsByCarId(Long carId);

    /**
     * 批量删除车辆信息
     * 
     * @param carIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBsnCarsByCarIds(Long[] carIds);
}
