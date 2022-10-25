package com.carrental.info.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.carrental.common.annotation.Excel;
import com.carrental.common.core.domain.BaseEntity;

/**
 * 门店信息对象 bsn_stores
 * 
 * @author Li Zijing
 * @date 2022-10-26
 */
public class BsnStores extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 门店ID */
    private Long storeId;

    /** 门店名称 */
    @Excel(name = "门店名称")
    private String storeName;

    /** 门店地址 */
    @Excel(name = "门店地址")
    private String storeAddress;

    /** 店长ID */
    @Excel(name = "店长ID")
    private Long storeManager;

    /** 所属车辆数 */
    @Excel(name = "所属车辆数")
    private Integer storeOwn;

    /** 门店类型 */
    @Excel(name = "门店类型")
    private String storeType;

    /** 门店状态 */
    @Excel(name = "门店状态")
    private String status;

    public void setStoreId(Long storeId) 
    {
        this.storeId = storeId;
    }

    public Long getStoreId() 
    {
        return storeId;
    }
    public void setStoreName(String storeName) 
    {
        this.storeName = storeName;
    }

    public String getStoreName() 
    {
        return storeName;
    }
    public void setStoreAddress(String storeAddress) 
    {
        this.storeAddress = storeAddress;
    }

    public String getStoreAddress() 
    {
        return storeAddress;
    }
    public void setStoreManager(Long storeManager) 
    {
        this.storeManager = storeManager;
    }

    public Long getStoreManager() 
    {
        return storeManager;
    }
    public void setStoreOwn(Integer storeOwn) 
    {
        this.storeOwn = storeOwn;
    }

    public Integer getStoreOwn() 
    {
        return storeOwn;
    }
    public void setStoreType(String storeType) 
    {
        this.storeType = storeType;
    }

    public String getStoreType() 
    {
        return storeType;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("storeId", getStoreId())
            .append("storeName", getStoreName())
            .append("storeAddress", getStoreAddress())
            .append("storeManager", getStoreManager())
            .append("storeOwn", getStoreOwn())
            .append("storeType", getStoreType())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
