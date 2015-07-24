package com.compareglobal.service.creditcard.api.beans;


import java.util.Collections;
import java.util.List;

public class CreditCard {

    private Long id;
    private String locale;
    private String name;
    private List<Fee> fees;

    public CreditCard() {
    }

    public CreditCard(Long id, String name, String locale) {
        this.id = id;
        this.name = name;
        this.locale = locale;
    }

    public Long getId() {
        return id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Fee> getFees() {
        fees.removeAll(Collections.singleton(null));
        return fees;
    }

    public void setFees(List<Fee> fees) {
        this.fees = fees;
    }
}
