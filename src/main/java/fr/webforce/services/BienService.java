package fr.webforce.services;

import fr.webforce.configurations.ConnectionBDD;
import fr.webforce.entities.AdresseEntity;
import fr.webforce.entities.BienEntity;
import fr.webforce.entities.TypeEntity;
import fr.webforce.repositories.CommonRepository;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class BienService implements CommonRepository<BienEntity, Integer> {

	private final Connection conn = new ConnectionBDD().getConnection();

	@Override
	public List<BienEntity> findAll() {
		var URL = "SELECT * FROM bien b JOIN adresse a ON b.id_adresse=a.id JOIN type t ON b.id_type=t.id";
		try(Statement st = conn.createStatement()){
			ResultSet res = st.executeQuery(URL);
			List<BienEntity> biens = new ArrayList<>();
			while(res.next()) {
				AdresseEntity ad = new AdresseEntity(
						res.getLong("a.id"),
						res.getInt("num"),
						res.getString("rue"),
						res.getString("cp"),
						res.getString("ville")
				);

				TypeEntity t = new TypeEntity();
				t.setId(res.getLong("t.id"));
				t.setEnum(res.getString("nom"));

				BienEntity b = new BienEntity(
						res.getLong("b.id"),
						res.getInt("nb_pieces"),
						res.getInt("surface"),
						res.getInt("prix"),
						res.getInt("annee"),
						res.getBoolean("garage"),
						res.getBoolean("terrasse"),
						res.getBoolean("balcon"),
						res.getBoolean("jardin"),
						t,
						ad
				);
				biens.add(b);
			}
			return biens;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public Collection<BienEntity> findByType(String type) {
		var URL = "SELECT * FROM bien b JOIN adresse a ON b.id_adresse=a.id JOIN type t ON b.id_type=t.id WHERE t.nom like ?";
		try(PreparedStatement st = conn.prepareStatement(URL)){
			st.setString(1, String.format("%%%s%%",type));
			ResultSet res = st.executeQuery();
			Collection<BienEntity> biens = new ArrayList<>();
			while(res.next()) {
				AdresseEntity ad = new AdresseEntity(
						res.getLong("a.id"),
						res.getInt("num"),
						res.getString("rue"),
						res.getString("cp"),
						res.getString("ville")
				);

				TypeEntity t = new TypeEntity();
				t.setId(res.getLong("t.id"));
				t.setEnum(res.getString("nom"));

				BienEntity b = new BienEntity(
						res.getLong("b.id"),
						res.getInt("nb_pieces"),
						res.getInt("surface"),
						res.getInt("prix"),
						res.getInt("annee"),
						res.getBoolean("garage"),
						res.getBoolean("terrasse"),
						res.getBoolean("balcon"),
						res.getBoolean("jardin"),
						t,
						ad
				);
				biens.add(b);
			}
			return biens;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public Collection<BienEntity> findByTown(String ville) {
		var URL = "SELECT * FROM bien b JOIN adresse a ON b.id_adresse=a.id JOIN type t ON b.id_type=t.id WHERE a.ville like ?";
		try(PreparedStatement st = conn.prepareStatement(URL)){
			st.setString(1, String.format("%%%s%%",ville));
			ResultSet res = st.executeQuery();
			Collection<BienEntity> biens = new ArrayList<>();
			while(res.next()) {
				AdresseEntity ad = new AdresseEntity(
						res.getLong("a.id"),
						res.getInt("num"),
						res.getString("rue"),
						res.getString("cp"),
						res.getString("ville")
				);

				TypeEntity t = new TypeEntity();
				t.setId(res.getLong("t.id"));
				t.setEnum(res.getString("nom"));

				BienEntity b = new BienEntity(
						res.getLong("b.id"),
						res.getInt("nb_pieces"),
						res.getInt("surface"),
						res.getInt("prix"),
						res.getInt("annee"),
						res.getBoolean("garage"),
						res.getBoolean("terrasse"),
						res.getBoolean("balcon"),
						res.getBoolean("jardin"),
						t,
						ad
				);
				biens.add(b);
			}
			return biens;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public Collection<BienEntity> findByPrice(Integer prix, double pourcentage) {
		var URL = "SELECT * FROM bien b JOIN adresse a ON b.id_adresse=a.id JOIN type t ON b.id_type=t.id WHERE b.prix BETWEEN ? and ?";
		try(PreparedStatement st = conn.prepareStatement(URL)){
			int reduc = (int) (prix * pourcentage);
			st.setInt(1, (prix - reduc));
			st.setInt(2, (prix + reduc));
			ResultSet res = st.executeQuery();
			Collection<BienEntity> biens = new ArrayList<>();
			while(res.next()) {
				AdresseEntity ad = new AdresseEntity(
						res.getLong("a.id"),
						res.getInt("num"),
						res.getString("rue"),
						res.getString("cp"),
						res.getString("ville")
				);

				TypeEntity t = new TypeEntity();
				t.setId(res.getLong("t.id"));
				t.setEnum(res.getString("nom"));

				BienEntity b = new BienEntity(
						res.getLong("b.id"),
						res.getInt("nb_pieces"),
						res.getInt("surface"),
						res.getInt("prix"),
						res.getInt("annee"),
						res.getBoolean("garage"),
						res.getBoolean("terrasse"),
						res.getBoolean("balcon"),
						res.getBoolean("jardin"),
						t,
						ad
				);
				biens.add(b);
			}
			return biens;
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
	public Optional<Integer> insert(BienEntity b) {
		String req = "INSERT INTO bien VALUES (null,?,?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement st = conn.prepareStatement(req)){
			st.setInt(1, b.getNbPieces());
			st.setInt(2, b.getSurface());
			st.setInt(3, b.getPrix());
			st.setInt(4, b.getAnnee());
			st.setBoolean(5, b.getGarage());
			st.setBoolean(6, b.getTerrase());
			st.setBoolean(7, b.getBalcon());
			st.setBoolean(8, b.getJardin());
			st.setLong(9, b.getType().getId());
			st.setLong(10,b.getAdresse().getId());

			int nb = st.executeUpdate();
			return Optional.of(nb);
		}catch (SQLException s){
			s.printStackTrace();
		}
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
	public Optional<Integer> delete(Long id) {
		String req = "DELETE FROM bien WHERE id = ?";
		try(PreparedStatement st = conn.prepareStatement(req)){
			st.setLong(1, id);
			int nb = st.executeUpdate();
			return Optional.of(nb);
		}catch (SQLException s){
			s.printStackTrace();
		}
		return Optional.empty();
	}
}
