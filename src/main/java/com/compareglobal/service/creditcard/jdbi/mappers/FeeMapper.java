package com.compareglobal.service.creditcard.jdbi.mappers;

import com.compareglobal.service.creditcard.api.beans.Fee;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeeMapper implements ResultSetMapper<Fee> {

    public Fee map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
        Fee fee = null;
        if (index == 0) {
            fee = new Fee(rs.getLong("id"),
                    rs.getString("type_value"),
                    rs.getInt("type_key"),
                    rs.getBigDecimal("amount"),
                    rs.getString("description"),
                    rs.getString("additional_info"));

                   }
        return fee;
    }
}
