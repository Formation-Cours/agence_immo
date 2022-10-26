package fr.webforce.services;

import fr.webforce.entities.TypeEntity;
import fr.webforce.repositories.CommonRepository;

import java.util.Collection;
import java.util.Optional;

public class TypeService implements CommonRepository<TypeEntity, Integer> {
	@Override
	public Collection<TypeEntity> findAll() {
		return null;
	}

	@Override
	public Optional<TypeEntity> findByID(Integer integer) {
		return Optional.empty();
	}

	@Override
	public Optional<Integer> insert(TypeEntity typeEntity) {
		return Optional.empty();
	}

	@Override
	public Optional<Integer> update(TypeEntity typeEntity) {
		return Optional.empty();
	}

	@Override
	public Optional<Integer> delete(Integer integer) {
		return Optional.empty();
	}
}
