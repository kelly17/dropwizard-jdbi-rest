/*
 * Copyright 2014 Eran C. Withana
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.compareglobal.service.creditcard;

import com.compareglobal.service.creditcard.jdbi.dao.FeeDAO;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.compareglobal.service.creditcard.jdbi.dao.CreditCardDAO;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.util.StringMapper;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: Eran Withana
 * Date: 7/7/14
 */
public class CreditCardApplication extends Application<CreditCardApplicationConfiguration> {
    private static Logger logger = Logger.getLogger(CreditCardApplication.class.getName());

    public static void main(String[] args) throws Exception {
        new CreditCardApplication().run(args);
    }

    @Override
    public String getName() {
        return "My Application";
    }


    @Override
    public void initialize(Bootstrap<CreditCardApplicationConfiguration> bootstrap) {

    }

    public void run(CreditCardApplicationConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {

        // create database connection using JDBI
        final DBIFactory factory = new DBIFactory();
        final DataSourceFactory dataSourceFactory = configuration.getDataSourceFactory();
        final DBI jdbi = factory.build(environment, dataSourceFactory, "jdbc");
        try (Handle handle = jdbi.open()) {
            List<String> rs = handle.createQuery("select * from credit_card ")
                    .map(StringMapper.FIRST)
                    .list();
        }
        // add resources
        //final UserDAO dao = jdbi.onDemand(UserDAO.class);
        final CreditCardDAO dao = jdbi.onDemand(CreditCardDAO.class);
        final FeeDAO fdao = jdbi.onDemand(FeeDAO.class);
        try {
            dao.findCreditCardById("1");
            dao.findCreditCards("pt-PT");
            logger.info("User table selected...");
        } catch (Exception e) {
            // probably the table already exists. Don't worry about it.
            if (e.getCause().getMessage().contains("already exists in Schema")) {
                logger.info("User table already exists.");
            } else {
                logger.log(Level.INFO, "User DB was not created", e);
            }

        }
        //environment.jersey().register(new UserResourceImpl(dao));
        environment.jersey().register(new CreditCardResourceImpl(dao,fdao));

    }

}
