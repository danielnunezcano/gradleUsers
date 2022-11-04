package com.lookiero.infrastructure.repository.jpa;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditingEntityJpa {

    @CreatedDate
    @Column(name = "CREATE_DATE", updatable = false, nullable = false)
    protected Date createdDate;

    @CreatedBy
    @Column(name = "CREATE_USER", updatable = false, nullable = false)
    protected String createdUser;

    @LastModifiedDate
    @Column(name = "UPDATE_DATE")
    protected Date updatedDate;

    @LastModifiedBy
    @Column(name = "UPDATE_USER")
    protected String updatedUser;

    @Column(name = "DEACTIVATED_DATE")
    protected Date deactivatedDate;

    @Column(name = "DEACTIVATED_USER")
    protected String deactivatedUser;

}