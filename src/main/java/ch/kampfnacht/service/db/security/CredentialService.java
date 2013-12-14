package ch.kampfnacht.service.db.security;

import org.springframework.security.core.userdetails.UserDetailsService;

import ch.kampfnacht.model.db.security.Credential;

public interface CredentialService extends UserDetailsService {
	Credential getCredential(String username);
	Credential addCredential(String username, String password);
}
