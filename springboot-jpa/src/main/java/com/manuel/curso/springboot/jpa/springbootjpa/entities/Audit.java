package com.manuel.curso.springboot.jpa.springbootjpa.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Embeddable
public class Audit {

    
    @Column(name = "create_at")
    private LocalDateTime createAt ;

    @Column(name = "update_at")
    private LocalDateTime updateAt ;

    @PrePersist
    public void prePersist() {

        System.out.println("evento del ciclo de vida del entity prepersist");

        this.createAt = LocalDateTime.now() ;

    }

    @PreUpdate
    public void preUpdate() {

        System.out.println("evento del ciclo de vida del entity preupdate");

        this.updateAt = LocalDateTime.now() ;

    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

}
