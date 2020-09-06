package com.dsoft.documents.service;

import javax.ws.rs.core.Response;
import java.net.URL;

import com.dsoft.documents.entity.TestEntity;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ServiceTest {

    @Deployment
    public static WebArchive deployment() {

        return ShrinkWrap.create(WebArchive.class)
            .addPackages(true, "com.dsoft.documents")
            .addAsWebInfResource("web.xml")
            .addAsResource("persistence.xml", "META-INF/persistence.xml")
            .addManifest()
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @ArquillianResource
    private URL baseUrl;

    @Test
    @RunAsClient
    public void testGet() {
        Response r = RestClientBuilder.newBuilder().baseUrl(baseUrl).build(Service.class).get();
        Assert.assertEquals(200, r.getStatus());
        Assert.assertEquals("test", r.readEntity(String.class));
    }
}
