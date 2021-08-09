package com.ksnote.jpastudy.entity;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
