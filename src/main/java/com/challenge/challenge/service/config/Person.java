package com.challenge.challenge.service.config;

public class Person extends Member {

    private boolean isCelebrity;

    public Person(Long id, String name, boolean isCelebrity) {
        super(id, name);
        this.isCelebrity =isCelebrity;
    }

    public boolean isCelebrity() {
        return isCelebrity;
    }


    public void setCelebrity(boolean celebrity) {
        isCelebrity = celebrity;
    }
}
