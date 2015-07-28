package com.compareglobal.service.creditcard;

import com.compareglobal.service.creditcard.api.beans.Compare;
import com.compareglobal.service.creditcard.api.beans.CreditCard;
import com.compareglobal.service.creditcard.api.CreditCardResource;
import com.compareglobal.service.creditcard.jdbi.dao.CreditCardDAO;
import com.compareglobal.service.creditcard.jdbi.dao.FeeDAO;
import com.compareglobal.service.creditcard.service.CreditCardService;
import org.apache.commons.lang.StringUtils;
import java.util.List;

public class CreditCardResourceImpl  implements CreditCardResource {
    private final CreditCardDAO creditCardDAO;
    private final FeeDAO feeDAO;
    private CreditCardService creditCardService;
    private List<CreditCard> creditCardsDto =  null;

    public CreditCardResourceImpl(CreditCardDAO dao, FeeDAO feed) {
        this.creditCardDAO = dao;
        this.feeDAO = feed;
    }

    public CreditCard getCreditCardById(final String userId) {
        return this.creditCardDAO.findCreditCardById(userId);
    }

    public List<CreditCard> home(Compare compare) {
        final String locale = compare.getLocale();
        if (StringUtils.isBlank(locale)) {
            throw new IllegalArgumentException("Parameter 'locale' is mandatory");
        }

        List<CreditCard> creditCards  =  this.creditCardDAO.findCreditCards(compare.getLocale());
        if (!creditCards.isEmpty()) {
            creditCardService = new CreditCardService(feeDAO);
            creditCardsDto = creditCardService.convert(creditCards, compare);
        }
        return creditCardsDto;
    }

}
