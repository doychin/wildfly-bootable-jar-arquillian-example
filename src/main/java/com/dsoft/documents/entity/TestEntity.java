package com.dsoft.documents.entity;

import javax.persistence.*;

@Entity
@Table(name = "TEST_ENTITY")
public class TestEntity {

    @Id
    @GeneratedValue
    private long id;

    public TestEntity(long id) {
        this.id = id;
    }

    public TestEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
