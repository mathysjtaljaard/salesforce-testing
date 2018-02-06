package org.taljaard.nextgear.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taljaard.nextgear.model.Account;
import org.taljaard.nextgear.model.Person;
import org.taljaard.nextgear.service.AccountService;
import org.taljaard.nextgear.service.PersonService;

@RestController
public class RequestController {

	@Autowired
    private PersonService personService;
	
	@Autowired
	private AccountService accountService;
 
    @RequestMapping("/accounts")
    public List<Account> accounts(OAuth2Authentication principal) {
        return accountService.getAccounts( principal);
    }
    
    @RequestMapping("/persons")
    public List<Person> listPeople(OAuth2Authentication principal) {
        return personService.listPeople( principal);
    }
}
