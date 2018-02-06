package org.taljaard.nextgear.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.taljaard.nextgear.model.Account;

@Service
public class AccountServiceImpl extends BaseService implements AccountService {

	@Override
	public List<Account> getAccounts(OAuth2Authentication principal) {
		String url = restUrl(principal) + "query/?q={q}";

		Map<String, String> params = new HashMap<>();
		params.put("q", "SELECT Id, Name, Type, Industry, Rating FROM Account");

		return restTemplate.getForObject(url, QueryResultAccount.class, params).records;
	}

	private static class QueryResultAccount extends QueryResult<Account> {
	}
}
