package fr.webforce.repositories;

import java.util.Collection;
import java.util.Optional;

public interface CommonRepository<T, ID> {
	Collection<T> findAll();
	Optional<T> findByID(ID id);
	Optional<Integer> insert(T t);
	Optional<Integer> update(T t);
	Optional<Integer> delete(ID id);
}
