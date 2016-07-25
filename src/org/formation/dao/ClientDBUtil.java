package org.formation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.formation.BeanMetier.Client;

public class ClientDBUtil {

	private static ClientDBUtil instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/client_tracker_h2";

	public static ClientDBUtil getInstance() throws Exception {
		if (instance == null) {
			instance = new ClientDBUtil();
		}

		return instance;
	}

	private ClientDBUtil() throws Exception {
		dataSource = getDataSource();
	}

	private DataSource getDataSource() throws Exception {

		Context context = new InitialContext();
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		return theDataSource;
	}

	public List<Client> getClient() throws Exception {
		List<Client> listClient = new ArrayList<>();
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			String sql = "select * from client order by nom";
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");

				Client c = new Client(id, nom, prenom, adresse);
				listClient.add(c);
			}
			return listClient;
		} finally {
			connection.close();
		}
	}

	public void addClient(Client client) throws SQLException {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = dataSource.getConnection();
			String sql = "insert into client (nom, prenom, adresse) values (?,?,?)";
			pst = connection.prepareStatement(sql);

			pst.setString(1, client.getNom());
			pst.setString(2, client.getPrenom());
			pst.setString(3, client.getAdresse());
			pst.execute();
		} finally {
			connection.close();
		}
	}

}
