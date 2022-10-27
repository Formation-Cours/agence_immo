package fr.webforce.services;

import fr.webforce.configurations.ConnectionBDD;
import fr.webforce.entities.TypeEntity;
import fr.webforce.repositories.CommonRepository;

import java.sql.*;
import java.util.Collection;
import java.util.Optional;

public class TypeService implements CommonRepository<TypeEntity, Integer> {
	private Connection conn = new ConnectionBDD().getConnection();


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
		String req = "INSERT INTO type (nom) VALUES (?)";
		try(PreparedStatement st = conn.prepareStatement(req, Statement.RETURN_GENERATED_KEYS)){
			st.setString(1, typeEntity.getNom().getName());

			int nb = st.executeUpdate();
			ResultSet res = st.getGeneratedKeys();
			if (res.next()){
				typeEntity.setId(res.getLong(1));
			}
			return Optional.of(nb);
		}catch (SQLException s){
			s.printStackTrace();
		}
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
