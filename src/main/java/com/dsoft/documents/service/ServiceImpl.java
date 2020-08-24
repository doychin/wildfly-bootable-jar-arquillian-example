package com.dsoft.documents.service;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

import com.dsoft.documents.entity.TestEntity;

@RequestScoped
public class ServiceImpl implements Service {

    @PersistenceContext
    private EntityManager entityManager;

    public Response get() {
        entityManager.persist(new TestEntity(0));
        return Response.ok().entity("test").build();
    }

}
