package com.compareglobal.service.creditcard.service;

import com.compareglobal.service.creditcard.api.beans.Compare;
import com.compareglobal.service.creditcard.api.beans.CreditCard;
import com.compareglobal.service.creditcard.api.beans.Fee;
import com.compareglobal.service.creditcard.jdbi.dao.FeeDAO;

import java.util.LinkedList;
import java.util.List;

public class CreditCardService {

    private FeeDAO feeDAO ;
    public CreditCardService(){}

    public CreditCardService(FeeDAO feed) {
        this.feeDAO = feed;
    }

    public List<CreditCard> convert(List<CreditCard> creditCardList, Compare compare) {
        List<Fee> feeList = new LinkedList<Fee>();
        List<CreditCard> creditcards = new LinkedList<CreditCard>();
        for (CreditCard cc : creditCardList) {
            Long id = cc.getId();
            feeList = this.feeDAO.getFeesById(id);
            if(feeList != null) {
                cc.setFees(feeList);
                creditcards.add(cc);
            }
        }
        return creditcards;
    }

}
