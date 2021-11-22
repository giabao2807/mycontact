package com.example.mycontact.service;

import com.example.mycontact.entity.Contact;
import com.example.mycontact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return (List<Contact>)contactRepository.findAll();
    }

    @Override
    public List<Contact> search(String term) {
        return contactRepository.findByNameContaining(term);
    }

    @Override
    public Contact findOne(Integer id) {
        Optional<Contact> isExist =contactRepository.findById(id);
        return isExist.isPresent()? isExist.get() :null ;
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }
}
