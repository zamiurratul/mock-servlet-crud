package com.zamiurratul.mock.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zamiurratul.mock.servlet.model.User;

public class UserDao {
	private final String DATABASE_URL = "";
	private final String DATABASE_USERNAME = "";
	private final String DATABASE_PASSWORD = "";

	private final String DML_INSERT_USER = "INSERT INTO TEST_USERS_2 (ID, EMPLOYEE_ID, FULLNAME, DESIGNATION, EMAIL, CONTACT_NO, JOINING_DATE)"
			+ " VALUES (?,?,?,?,?,?,?)";
	
	private final String DML_UPDATE_USER = "UPDATE TEST_USERS_2 SET EMPLOYEE_ID=?, FULLNAME=?, DESIGNATION=?, EMAIL=?, CONTACT_NO=?, JOINING_DATE=? WHERE ID=?";
	
	private final String DML_DELETE_USER = "DELETE FROM TEST_USERS_2 WHERE ID=?";
	
	private final String DML_FIND_USER_BY_ID = "SELECT * FROM TEST_USERS_2 WHERE ID=?";
	
	private final String DML_FIND_ALL_USERS = "SELECT * FROM TEST_USERS_2";
	
	private final String DML_FIND_MAX_ID = "SELECT MAX(ID) FROM TEST_USERS_2";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
	}
	
	public boolean save(User user) {
		boolean success = false;
		System.out.println(DML_INSERT_USER);
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DML_INSERT_USER);) {
			preparedStatement.setLong(1, maxId() + 1);
			preparedStatement.setString(2, user.getEmployeeId());
			preparedStatement.setString(3, user.getFullName());
			preparedStatement.setString(4, user.getDesignation());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getContactNo());
			preparedStatement.setDate(7, user.getJoiningDate());
			
			int rowCount = preparedStatement.executeUpdate();
			if (rowCount > 0) {
				success = true;
				System.out.println("ROW_INSERTED: " + rowCount);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER NOT FOUND");
		} catch (SQLException e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		}
		return success;
	}
	
	public boolean update(User user) {
		boolean success = false;
		System.out.println(DML_UPDATE_USER);
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DML_UPDATE_USER);) {
			preparedStatement.setString(1, user.getEmployeeId());
			preparedStatement.setString(2, user.getFullName());
			preparedStatement.setString(3, user.getDesignation());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getContactNo());
			preparedStatement.setDate(6, user.getJoiningDate());
			preparedStatement.setLong(7, user.getId());
			
			int rowCount = preparedStatement.executeUpdate();
			if (rowCount > 0) {
				success = true;
				System.out.println("ROW_UPDATED: " + rowCount);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER NOT FOUND");
		} catch (SQLException e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		}
		return success;
	}
	
	public boolean delete(long id) {
		boolean success = false;
		System.out.println(DML_DELETE_USER);
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DML_DELETE_USER);) {
			preparedStatement.setLong(1, id);
			
			int rowCount = preparedStatement.executeUpdate();
			if (rowCount > 0) {
				success = true;
				System.out.println("ROW_DELETED: " + rowCount);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER NOT FOUND");
		} catch (SQLException e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		}
		return success;
	}
	
	public User findbyId(long id) {
		User user = null;
		System.out.println(DML_FIND_USER_BY_ID);
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DML_FIND_USER_BY_ID);) {
			preparedStatement.setLong(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getLong("ID"));
				user.setEmployeeId(resultSet.getString("EMPLOYEE_ID"));
				user.setFullName(resultSet.getString("FULLNAME"));
				user.setDesignation(resultSet.getString("DESIGNATION"));
				user.setEmail(resultSet.getString("EMAIL"));
				user.setContactNo(resultSet.getString("CONTACT_NO"));
				user.setJoiningDate(resultSet.getDate("JOINING_DATE"));
			}
			if (user != null) {
				System.out.println("USER: " + user.toString());
			}
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER NOT FOUND");
		} catch (SQLException e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		}
		return user;
	}
	
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		System.out.println(DML_FIND_ALL_USERS);
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DML_FIND_ALL_USERS);) {			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getLong("ID"));
				user.setEmployeeId(resultSet.getString("EMPLOYEE_ID"));
				user.setFullName(resultSet.getString("FULLNAME"));
				user.setDesignation(resultSet.getString("DESIGNATION"));
				user.setEmail(resultSet.getString("EMAIL"));
				user.setContactNo(resultSet.getString("CONTACT_NO"));
				user.setJoiningDate(resultSet.getDate("JOINING_DATE"));
				System.out.println("USER: " + user.toString());
				users.add(user);
			}
			if (!users.isEmpty()) {
				System.out.println("TOTAL_USER: " + users.size());
			}
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER NOT FOUND");
		} catch (SQLException e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		}
		return users;
	}
	
	public long maxId() {
		long maxId = 0L; 
		System.out.println(DML_FIND_MAX_ID);
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DML_FIND_MAX_ID);) {
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				maxId = resultSet.getLong(1);
				System.out.println("MAX_ID: " + maxId);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER NOT FOUND");
		} catch (SQLException e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		}
		return maxId;
	}
}
