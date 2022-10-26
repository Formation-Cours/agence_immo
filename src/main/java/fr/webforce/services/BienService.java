package fr.webforce.services;

import fr.webforce.configurations.ConnectionBDD;
import fr.webforce.entities.BienEntity;
import fr.webforce.repositories.CommonRepository;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.Optional;

public class BienService implements CommonRepository<BienEntity, Integer> {

	private final Connection conn = new ConnectionBDD().getConnection();

	@Override
	public Collection<BienEntity> findAll() {
		var URL = "SELECT * FROM bien b JOIN adresse a ON b.id_adresse=a.id JOIN type t ON b.id_type=t.id";
		try(Statement st = conn.createStatement()){
			ResultSet res = st.executeQuery(URL);
			while(res.next()) {
				System.out.println(res.getLong("prix"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Optional<BienEntity> findByID(Integer integer) {
		return Optional.empty();
	}

	@Override
	public Optional<Integer> insert(BienEntity bienEntity) {
		return Optional.empty();
	}

	@Override
	public Optional<Integer> update(BienEntity bienEntity) {
		return Optional.empty();
	}

	@Override
	public Optional<Integer> delete(Integer integer) {
		return Optional.empty();
	}
}
