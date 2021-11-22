package com.example.mycontact.service;

import com.example.mycontact.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    List<Contact> search(String term);

    Contact findOne(Long id);

    void save(Contact id);

    void delete(Long id);
}
