package org.taljaard.nextgear.service;


import java.util.List;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.taljaard.nextgear.model.Person;

public interface PersonService {
    
    public void addPerson(Person person, OAuth2Authentication principal);
    public List<Person> listPeople(OAuth2Authentication principal);
    public void removePerson(String id, OAuth2Authentication principal);
}
