package org.taljaard.nextgear.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.taljaard.nextgear.model.Person;

@Service
public class PersonServiceImpl extends BaseService implements PersonService {

	public PersonServiceImpl() {
	}
	
	@Override
	public void addPerson(Person person, OAuth2Authentication principal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Person> listPeople(OAuth2Authentication principal) {
    		String url = restUrl(principal) + "query/?q={q}";
    		
    		Map<String, String> params = new HashMap<>();
        params.put("q", "SELECT Id, FirstName, LastName FROM contact");
        
        return restTemplate.getForObject(url, QueryResultPerson.class, params).records;
	}

	@Override
	public void removePerson(String id, OAuth2Authentication principal) {
		// TODO Auto-generated method stub
		
	}
    
	private static class QueryResultPerson extends QueryResult<Person> {}
	
}
