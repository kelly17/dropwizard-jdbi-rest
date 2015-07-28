package com.compareglobal.service.creditcard.api;

import com.codahale.metrics.annotation.Timed;
import com.compareglobal.service.creditcard.api.beans.Compare;
import com.compareglobal.service.creditcard.api.beans.CreditCard;

import javax.swing.text.html.parser.Entity;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/creditcard")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CreditCardResource {

    @GET
    @Path("/{id}")
    public CreditCard getCreditCardById(@PathParam("id") final String userId);

    @POST
    @Timed
    @Path("/compare")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<CreditCard> home(Compare compare);


}
