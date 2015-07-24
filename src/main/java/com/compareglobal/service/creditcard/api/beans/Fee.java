package com.compareglobal.service.creditcard.api.beans;

import java.math.BigDecimal;
import java.util.List;

public class Fee {
    private Long id;
    private BigDecimal amount;
    private String description;
    private String additionalInfo;
    private Integer typeKey;
    private String typeValue;

    public Fee() {}

    public Fee(Long id, String typeValue, Integer typeKey, BigDecimal amount, String desc, String addtl) {
        this.id = id;
        this.typeValue = typeValue;
        this.typeKey = typeKey;
        this.amount = amount;
        this.description = desc;
        this.additionalInfo = addtl;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Integer getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(Integer typeKey) {
        this.typeKey = typeKey;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }
}
