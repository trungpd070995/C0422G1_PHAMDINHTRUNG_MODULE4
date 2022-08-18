package com.email.repository;

import com.email.model.EmailBox;

import java.util.List;

public interface IEmailBoxRepository {

    EmailBox findAll();

    List<String> findLanguage();

    List<Integer> findPageSize();

    void save(EmailBox emailBox);

}
