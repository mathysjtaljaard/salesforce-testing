package org.taljaard.nextgear.service;

import java.util.List;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.taljaard.nextgear.model.Account;

public interface AccountService {

	public List<Account> getAccounts(OAuth2Authentication principal);
}
