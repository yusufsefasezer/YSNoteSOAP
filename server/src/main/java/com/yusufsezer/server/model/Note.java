package com.yusufsezer.server.model;

import com.yusufsezer.server.contract.BaseEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class Note extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    @Lob
    @Column(length = 1000)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
