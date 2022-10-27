package fr.webforce.services;

import fr.webforce.configurations.ConnectionBDD;
import fr.webforce.entities.AdresseEntity;
import fr.webforce.repositories.CommonRepository;

import java.sql.*;
import java.util.Collection;
import java.util.Optional;

public class AdresseService implements CommonRepository<AdresseEntity, Integer> {
	private Connection conn = new ConnectionBDD().getConnection();

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
		String req = "INSERT INTO adresse (num, rue, cp, ville) VALUES (?, ?, ?, ?)";
		try (PreparedStatement st = conn.prepareStatement(req, Statement.RETURN_GENERATED_KEYS)) {
			st.setInt(1, adresseEntity.getNum());
			st.setString(2, adresseEntity.getRue());
			st.setString(3, adresseEntity.getCp());
			st.setString(4, adresseEntity.getVille());

			int nb = st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()){
				adresseEntity.setId(rs.getLong(1));
			}
			return Optional.of(nb);
		} catch (SQLException s) {
			s.printStackTrace();
		}
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
