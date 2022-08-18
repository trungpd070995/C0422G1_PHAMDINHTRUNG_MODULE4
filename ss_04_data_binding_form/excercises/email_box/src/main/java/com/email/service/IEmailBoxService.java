package com.email.service;

import com.email.model.EmailBox;

import java.util.List;

public interface IEmailBoxService {

    EmailBox findAll();

    List<String> findLanguage();

    List<Integer> findPageSize();

    void save(EmailBox emailBox);
}
