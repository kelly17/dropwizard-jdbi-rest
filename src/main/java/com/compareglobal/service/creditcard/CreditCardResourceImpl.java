package com.compareglobal.service.creditcard;

import com.compareglobal.service.creditcard.api.beans.CreditCard;
import com.compareglobal.service.creditcard.api.CreditCardResource;
import com.compareglobal.service.creditcard.api.beans.Fee;
import com.compareglobal.service.creditcard.jdbi.dao.CreditCardDAO;
import com.compareglobal.service.creditcard.jdbi.dao.FeeDAO;

import java.util.LinkedList;
import java.util.List;

public class CreditCardResourceImpl  implements CreditCardResource {
    private final CreditCardDAO creditCardDAO;
    private final FeeDAO feeDAO;

    public CreditCardResourceImpl(CreditCardDAO dao, FeeDAO feed) {
        this.creditCardDAO = dao;
        this.feeDAO = feed;
    }

    public CreditCard getCreditCardById(final String userId) {

        return this.creditCardDAO.findCreditCardById(userId);
    }

    public List<CreditCard> getCreditCards(final String locale) {
        List<CreditCard> ccList  =  this.creditCardDAO.findCreditCards(locale);
        List<Fee> feeList = new LinkedList<Fee>();
        List<CreditCard> creditcards = new LinkedList<CreditCard>();
        for (CreditCard cc : ccList) {
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
