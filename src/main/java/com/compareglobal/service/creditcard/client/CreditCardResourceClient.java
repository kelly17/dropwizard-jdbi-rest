package com.compareglobal.service.creditcard.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.compareglobal.service.creditcard.api.CreditCardResource;
import com.compareglobal.service.creditcard.api.beans.CreditCard;

import javax.ws.rs.core.MediaType;
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
    public List<CreditCard> getCreditCards(String locale) {
        final ClientResponse clientResponse = client.resource(
                resourceUrl + "/" + locale).type(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        return (List<CreditCard>) clientResponse.getEntity(CreditCard.class);
    }
}
