package com.compareglobal.service.creditcard.jdbi.dao;

import com.compareglobal.service.creditcard.api.beans.CreditCard;
import com.compareglobal.service.creditcard.jdbi.mappers.CreditCardMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;


@RegisterMapper(CreditCardMapper.class)
public interface CreditCardDAO {

    public static final String CREDITCARD = "credit_card";

    @SqlQuery("select * from " + CREDITCARD + " where id = :id")
    CreditCard findCreditCardById(@Bind("id") String id);

    @SqlQuery("select * from " + CREDITCARD + " where locale = :locale")
    List<CreditCard> findCreditCards(@Bind("locale") String locale);


}
