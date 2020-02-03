package com.challenge.challenge.service.config;

import java.util.ArrayList;
import java.util.List;

public class Team extends Member {

    private List<Member> members = new ArrayList<Member>();

    public Team(Long id, String name) {
        super(id, name);
    }

    public List<Member> getMembers() {
        return members;
    }

    public void addMember(Member member){
        this.members.add(member);
    }
}
