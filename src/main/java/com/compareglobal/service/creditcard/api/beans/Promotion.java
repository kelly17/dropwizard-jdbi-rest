package com.compareglobal.service.creditcard.api.beans;

public class Promotion {
    private Long id;
    private String title;
    private String description;
    private String condition;
    private String typeValue;
    private Integer typeKey;

    public Promotion() {}

    public Promotion(Long id, String typeValue, Integer typeKey, String title, String desc, String cond) {
        this.id = id;
        this.typeKey = typeKey;
        this.typeValue = typeValue;
        this.description = desc;
        this.condition = cond;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public Integer getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(Integer typeKey) {
        this.typeKey = typeKey;
    }
}
