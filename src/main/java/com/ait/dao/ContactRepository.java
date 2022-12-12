package com.ait.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ait.model.Contact;
@Repository
public interface ContactRepository extends MongoRepository<Contact, Integer> {

}
