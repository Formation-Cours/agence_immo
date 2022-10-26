package fr.webforce.services;

import fr.webforce.entities.AdresseEntity;
import fr.webforce.repositories.CommonRepository;

import java.util.Collection;
import java.util.Optional;

public class AdresseService implements CommonRepository<AdresseEntity, Integer> {
	@Override
	public Collection<AdresseEntity> findAll() {
		return null;
	}

	@Override
	public Optional<AdresseEntity> findByID(Integer integer) {
		return Optional.empty();
	}

	@Override
	public Optional<Integer> insert(AdresseEntity adresseEntity) {
		return Optional.empty();
	}

	@Override
	public Optional<Integer> update(AdresseEntity adresseEntity) {
		return Optional.empty();
	}

	@Override
	public Optional<Integer> delete(Integer integer) {
		return Optional.empty();
	}
}
