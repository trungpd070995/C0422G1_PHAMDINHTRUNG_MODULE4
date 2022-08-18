package com.email.repository;
import com.email.model.EmailBox;
import org.springframework.stereotype.Repository;
import java.util.LinkedList;
import java.util.List;

@Repository
public class EmailBoxRepositoryImpl implements IEmailBoxRepository {
    private static EmailBox emailBox = new EmailBox( "English", 5, true, "No");

    @Override
    public EmailBox findAll() {
        return emailBox;
    }

    @Override
    public List<String> findLanguage() {
        List<String> language = new LinkedList<>();
        language.add("English");
        language.add("Vietnamese");
        language.add("Chinese");
        language.add("Japanese");
        return language;
    }

    @Override
    public List<Integer> findPageSize() {
        List<Integer> findPage = new LinkedList<>();
        findPage.add(5);
        findPage.add(10);
        findPage.add(15);
        findPage.add(25);
        findPage.add(50);
        findPage.add(100);
        return findPage;
    }

    @Override
    public void save(EmailBox emailBox) {
        emailBox.setLanguages(emailBox.getLanguages());
        emailBox.setPageSize(emailBox.getPageSize());
        emailBox.setSpamsFilter(emailBox.isSpamsFilter());
        emailBox.setSignature(emailBox.getSignature());
    }
}
