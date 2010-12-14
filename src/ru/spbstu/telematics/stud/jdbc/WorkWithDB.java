package ru.spbstu.telematics.stud.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class WorkWithDB {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		WorkWithDB workWithDB = new WorkWithDB();
//		workWithDB.foo();
//		workWithDB.baz();
//		workWithDB.insert();
//		workWithDB.update();
		workWithDB.updatable();
	}

	private void updatable() throws SQLException {
		String url = "jdbc:postgresql://localhost/lukash";
		Connection con = DriverManager.getConnection(url);
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("select id as person_id, name from person");
		
		while(rs.next()) {
			Integer id = rs.getInt("person_id");
			System.out.println("Baz: " + id);
			if (id == 6) {
				rs.updateString("name", "Dennis Underwood");
				rs.updateRow();
			}
		}
		
		con.close();
	}

	private void insert() throws SQLException {
		String url = "jdbc:postgresql://localhost/lukash";
		Connection con = DriverManager.getConnection(url);
		PreparedStatement ps = con.prepareStatement("insert into person (name) values (?)");
		ps.setString(1, "Fenix");
		int r = ps.executeUpdate();
		System.out.println("inserted : " + r);
		ResultSet keys = ps.getGeneratedKeys();
		while (keys.next()) {
			System.out.println(keys.getInt(1));
		}
		
		ps.close();
		con.close();
		
	}
	private void update() throws SQLException {
		String url = "jdbc:postgresql://localhost/lukash";
		Connection con = DriverManager.getConnection(url);
		PreparedStatement ps = con.prepareStatement("update person set name=? where id=?");
		ps.setString(1, "Dennis2");
		ps.setInt(2, 6);
		int r = ps.executeUpdate();
		System.out.println("updated : " + r);
		ps.close();
		con.close();
		
	}

	private void transaction() throws SQLException {
		String url = "jdbc:postgresql://localhost/lukash";
		Connection con = DriverManager.getConnection(url);
		
		con.setAutoCommit(false);
		//first action
		PreparedStatement ps = con.prepareStatement("update person set name=? where id=?");
		ps.setString(1, "Dennis2");
		ps.setInt(2, 6);
		int r = ps.executeUpdate();
		System.out.println("updated : " + r);
		ps.close();
		//another actions
		
		Savepoint p = con.setSavepoint();
		
		//...
		con.commit();
//		con.rollback();
//		con.rollback(p);
		con.close();
		
	}

	private void baz() throws SQLException {
		String url = "jdbc:postgresql://localhost/lukash";
		Connection con = DriverManager.getConnection(url);
		PreparedStatement ps = con.prepareStatement("select id as person_id from person where name=?");
		ps.setString(1, "Dennis");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Integer id = rs.getInt("person_id");
			System.out.println("Baz: " + id);
		}
		
		ps.close();
		con.close();
	}

	private void foo() throws SQLException {
		String name = "dennis";

		String url = "jdbc:postgresql://localhost/lukash";
		Connection con = DriverManager.getConnection(url);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select id as person_id from person where name='" + name + "'");
		
		while(rs.next()) {
			Integer id = rs.getInt("person_id");
			System.out.println(id);
		}
		
		con.close();
	}
}
