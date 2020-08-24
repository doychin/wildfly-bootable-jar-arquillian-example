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
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
            .addClass(Activation.class)
            .addClass(ServiceImpl.class)
            .addClass(Service.class)
            .addClass(TestEntity.class)
            .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        return archive;
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
