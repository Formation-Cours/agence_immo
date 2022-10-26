package fr.webforce.configurations;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionBDD {
	private static final Properties props = new Properties();

	public ConnectionBDD() {
		try(FileInputStream fis = new FileInputStream("bdd.properties")){
			props.load(fis);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Connection getConnection() {
		Connection conn;
		try {
			Class.forName(props.getProperty("jdbc.driver.class"));
			conn = DriverManager.getConnection(
					props.getProperty("jdbc.url"),
					props.getProperty("jdbc.user"),
					props.getProperty("jdbc.password")
			);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
		return conn;
	}
}
