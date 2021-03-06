package com.example.mycontact.repository;

import com.example.mycontact.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Long> {
    List<Contact> findByNameContaining(String term);
}
