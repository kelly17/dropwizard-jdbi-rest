package com.compareglobal.service.creditcard.client;

import com.compareglobal.service.creditcard.api.beans.Compare;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.compareglobal.service.creditcard.api.CreditCardResource;
import com.compareglobal.service.creditcard.api.beans.CreditCard;

import javax.swing.text.html.parser.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class CreditCardResourceClient implements CreditCardResource {

    private final Client client = new Client();
    private final String resourceUrl;

    public CreditCardResourceClient(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    @Override
    public CreditCard getCreditCardById(String userId) {
        final ClientResponse clientResponse = client.resource(
                resourceUrl + "/" + userId).type(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);
        return clientResponse.getEntity(CreditCard.class);
    }

    @Override
    public List<CreditCard> home(Compare compare) {
        return null;
    }
}
