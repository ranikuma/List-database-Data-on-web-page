package studyeasy.org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import studyeasy.org.entity.Users;

public class UsersModel {

	public List<Users> listUsers(DataSource dataSource) {
		List<Users> listUsers = new ArrayList<Users>();
		// Initialize connection object
		System.out.println("ListUsers");
		Connection connect = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {

			connect = dataSource.getConnection();

			// Create a SQL Query
			String query = "select * from user2";
			stmt = connect.createStatement();
			rs = stmt.executeQuery(query);

			// Process the sql statement
			while (rs.next()) {
				listUsers.add(new Users(rs.getInt("user_id"), rs.getString("username"), rs.getString("email")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ListUsers");

		return listUsers;
	}

	public void addUser(DataSource dataSource, Users newUser) {
		// TODO Auto-generated method stub
		System.out.println("UserModel");
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String username = newUser.getUserName();
			String email = newUser.getEmail();
			String query = "insert into user2 (username,email) values (?,?)";
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateUser(DataSource dataSource, Users newUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			int userId = newUser.getUsersId();
			String userName = newUser.getUserName();
			String email = newUser.getEmail();
			String query = "update studyeasy_db.user2 set username = ? , email = ? where user_id = ?";
			statement = connect.prepareStatement(query);
			statement.setString(1, userName);
			statement.setString(2, email);
			statement.setInt(3, userId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteUser(DataSource dataSource, int userId) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String query = "delete from user2 where user_id = ?";
			statement = connect.prepareStatement(query);
			statement.setInt(1, userId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
