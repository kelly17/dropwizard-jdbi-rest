package com.compareglobal.service.creditcard.api;

import com.compareglobal.service.creditcard.api.beans.CreditCard;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/creditcard")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CreditCardResource {

    @GET
    @Path("/{id}")
    public CreditCard getCreditCardById(@PathParam("id") final String userId);

    @GET
    @Path("/locale/{locale}")
    public List<CreditCard> getCreditCards(@PathParam("locale") final String locale);

}
