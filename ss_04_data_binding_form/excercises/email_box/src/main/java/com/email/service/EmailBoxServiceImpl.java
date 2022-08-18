package com.email.service;

import com.email.model.EmailBox;
import com.email.repository.IEmailBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailBoxServiceImpl implements IEmailBoxService {

    @Autowired
    private IEmailBoxRepository emailBoxRepository;

    @Override
    public EmailBox findAll() {
        return emailBoxRepository.findAll();
    }

    @Override
    public List<String> findLanguage() {
        return emailBoxRepository.findLanguage();
    }

    @Override
    public List<Integer> findPageSize() {
        return emailBoxRepository.findPageSize();
    }

    @Override
    public void save(EmailBox emailBox) {
        emailBoxRepository.save(emailBox);
    }
}
