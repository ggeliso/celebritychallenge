package com.challenge.challenge.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "people")
public class People implements Serializable {

    @Id
    private Long id;
    private String name;

    private boolean isCelebrity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCelebrity() {
        return isCelebrity;
    }

    public void setCelebrity(boolean celebrity) {
        isCelebrity = celebrity;
    }

    private static final long serialVersionUID = -6260159974278067688L;
}
