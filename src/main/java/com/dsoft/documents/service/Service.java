package com.dsoft.documents.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("service")
public interface Service {
    @GET
     Response get();
}
