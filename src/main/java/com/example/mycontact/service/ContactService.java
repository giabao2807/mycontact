package com.example.mycontact.service;

import com.example.mycontact.entity.Contact;

import java.util.List;

public interface ContactService {
    Iterable<Contact> findAll();

    List<Contact> search(String term);

    Contact findOne(Integer id);

    void save(Contact id);

    void delete(Integer id);
}
