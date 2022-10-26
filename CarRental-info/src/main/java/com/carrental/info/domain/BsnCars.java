package com.carrental.info.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.carrental.common.annotation.Excel;
import com.carrental.common.core.domain.BaseEntity;

/**
 * 车辆信息对象 bsn_cars
 * 
 * @author carrental
 * @date 2022-10-26
 */
public class BsnCars extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 车辆ID */
    private Long carId;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String carPlate;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 型号 */
    @Excel(name = "型号")
    private String type;

    /** 车型 */
    @Excel(name = "车型")
    private String model;

    /** 租金/天 */
    @Excel(name = "租金/天")
    private BigDecimal price;

    /** 押金 */
    @Excel(name = "押金")
    private BigDecimal deposit;

    /** 车辆照片 */
    @Excel(name = "车辆照片")
    private String img;

    /** 归属门店ID */
    @Excel(name = "归属门店ID")
    private Long storeId;

    /** 归属门店 */
    @Excel(name = "归属门店")
    private String storeName;

    /** 车辆状态（0正常1停用2已租） */
    @Excel(name = "车辆状态", readConverterExp = "0=正常1停用2已租")
    private String status;

    public void setCarId(Long carId) 
    {
        this.carId = carId;
    }

    public Long getCarId() 
    {
        return carId;
    }
    public void setCarPlate(String carPlate) 
    {
        this.carPlate = carPlate;
    }

    public String getCarPlate() 
    {
        return carPlate;
    }
    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setDeposit(BigDecimal deposit) 
    {
        this.deposit = deposit;
    }

    public BigDecimal getDeposit() 
    {
        return deposit;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setStoreId(Long storeId) 
    {
        this.storeId = storeId;
    }

    public Long getStoreId() 
    {
        return storeId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("carId", getCarId())
            .append("carPlate", getCarPlate())
            .append("brand", getBrand())
            .append("type", getType())
            .append("model", getModel())
            .append("price", getPrice())
            .append("deposit", getDeposit())
            .append("img", getImg())
            .append("storeId", getStoreId())
            .append("storeName", getStoreName())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
