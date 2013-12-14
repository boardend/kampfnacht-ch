package ch.kampfnacht.service.db.security;

import org.springframework.data.repository.Repository;

import ch.kampfnacht.model.db.security.Credential;

interface CredentialRepository extends Repository<Credential, Long> {
	Credential findByUsername(String username);
	
	Credential save(Credential credential);
}
