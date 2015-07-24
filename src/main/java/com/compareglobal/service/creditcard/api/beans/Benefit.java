package com.compareglobal.service.creditcard.api.beans;

public class Benefit {

    private Long id;
    private String description;
    private String additionalInfo;
    private Integer typeKey;
    private String typeValue;

    public Benefit() {}

    public Benefit(Long id, String typeValue, Integer typeKey, String desc, String addtl) {
        this.id = id;
        this.typeKey = typeKey;
        this.typeValue = typeValue;
        this.description = desc;
        this.additionalInfo = addtl;
    }

    public Long getId() {
        return id;
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
