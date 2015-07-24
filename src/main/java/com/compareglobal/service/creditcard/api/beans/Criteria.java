package com.compareglobal.service.creditcard.api.beans;


public class Criteria {
    private Long id;
    private String description;
    private String additionalInfo;
    private Integer typeKey;
    private String typeValue;
    private Integer maximum;
    private Integer minimum;

    public Criteria() {}

    public Criteria(Long id, String typeValue, Integer typeKey, String desc, String addtl, int max, int min) {
        this.id = id;
        this.typeKey = typeKey;
        this.typeValue = typeValue;
        this.description = desc;
        this.additionalInfo = addtl;
        this.maximum = max;
        this.minimum = min;
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

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }
}
