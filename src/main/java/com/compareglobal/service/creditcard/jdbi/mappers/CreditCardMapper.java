package com.compareglobal.service.creditcard.jdbi.mappers;

import com.compareglobal.service.creditcard.api.beans.CreditCard;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CreditCardMapper implements ResultSetMapper<CreditCard> {

    public CreditCard map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
       return new CreditCard(rs.getLong("id"),rs.getString("name"),rs.getString("locale"));
    }
}
