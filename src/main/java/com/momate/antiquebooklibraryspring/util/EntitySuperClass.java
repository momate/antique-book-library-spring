package com.momate.antiquebooklibraryspring.util;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class EntitySuperClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @PrePersist
    protected void onCreate(){
        this.createDate = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updateDate = LocalDateTime.now();
    }
}
