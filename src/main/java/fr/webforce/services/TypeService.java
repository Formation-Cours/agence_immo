package fr.webforce.services;

import fr.webforce.configurations.ConnectionBDD;
import fr.webforce.entities.TypeEntity;
import fr.webforce.repositories.CommonRepository;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class TypeService implements CommonRepository<TypeEntity, Integer> {
	private Connection conn = new ConnectionBDD().getConnection();


	@Override
	public Collection<TypeEntity> findAll() {
		try(Statement st = conn.createStatement()){
			ResultSet rs = st.executeQuery("SELECT * FROM type");
			Collection<TypeEntity> types = new ArrayList<>();
			while(rs.next()){
				TypeEntity type = new TypeEntity();
				type.setId(rs.getLong("id"));
				type.setEnum(rs.getString("nom"));

				types.add(type);
			}
			return types;
		}catch (SQLException s){
			s.printStackTrace();
		}
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
