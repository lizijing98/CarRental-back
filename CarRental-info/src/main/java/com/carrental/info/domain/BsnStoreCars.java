package com.carrental.info.domain;

import com.carrental.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 门店车辆分配对象 bsn_store_cars
 *
 * @author Li Zijing
 * @date 2022-10-28
 */
public class BsnStoreCars extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 车辆ID
     */
    private Long carId;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 车牌号
     */
    private String carPlate;

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getCarId() {
        return carId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("storeId", getStoreId())
                .append("carId", getCarId())
                .append("storeName", getStoreName())
                .append("carPlate", getCarPlate())
                .toString();
    }
}
