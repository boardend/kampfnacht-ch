package ch.kampfnacht.service.db.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import ch.kampfnacht.model.db.security.Credential;

@Component("credentialService")
@Transactional
public class CredentialServiceImpl implements CredentialService {

	private final CredentialRepository credentialRepository;

	@Autowired
	public CredentialServiceImpl(CredentialRepository credentialRepository) {
		this.credentialRepository = credentialRepository;
	}

	@Override
	public Credential getCredential(String username) {
		Assert.notNull(username, "Username must not be null");
		Assert.hasLength(username, "Username must not be empty");
		return credentialRepository.findByUsername(username);
	}

	@Override
	public Credential addCredential(String username, String password) {
		Credential cred = new Credential();
		cred.setUsername(username);
		cred.setPassword(password);
		return credentialRepository.save(cred);
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		return getCredential(username);
	}

}
