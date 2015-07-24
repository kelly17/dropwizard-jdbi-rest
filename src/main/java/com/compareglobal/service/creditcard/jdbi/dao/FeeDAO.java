package com.compareglobal.service.creditcard.jdbi.dao;

import com.compareglobal.service.creditcard.api.beans.Fee;
import com.compareglobal.service.creditcard.jdbi.mappers.FeeMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(FeeMapper.class)
public interface FeeDAO {

    public static final String FEE = "fee";

    @SqlQuery("select * from " + FEE + " where creditcard_id = :id")
    public List<Fee> getFeesById(@Bind("id") long id);
}
