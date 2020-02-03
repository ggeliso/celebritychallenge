package com.challenge.challenge.repository;

import com.challenge.challenge.model.People;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeopleRepository extends CrudRepository<People, Long> {

}
