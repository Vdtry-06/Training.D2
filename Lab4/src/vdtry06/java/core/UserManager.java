package vdtry06.java.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.regex.Pattern;

public class UserManager {
	
	private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
	private static final String PASSWORD_REGEX = "^(?=.*[A-Z]).{6,12}$";
	private static final String FULLNAME_REGEX = "^[A-Za-z ]+$";
	
	private boolean validateEmail(String email) {
		return Pattern.matches(EMAIL_REGEX, email);
	}
	
	private boolean validatePassword(String password) {
		return Pattern.matches(PASSWORD_REGEX, password);
	}
	
	private boolean validateFullName(String fullName) {
		return Pattern.matches(FULLNAME_REGEX, fullName);
	}
	
	public void addUser(User user, String role) {
		String sql = "INSERT INTO users(full_name, email, password, role, exp_in_year, pro_skill) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection con = DatabaseManager.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {
			
			if (!validateFullName(user.getFullName())) {
				System.out.println("Ten day du chi duoc chua chu cai va dau cach");
				return;
			} else stmt.setString(1, user.getFullName());
			if (!validateEmail(user.getEmail())) {
				System.out.println("Loi email khong dung dinh dang");
				return;
			} else stmt.setString(2, user.getEmail());
			if (!validatePassword(user.getPassword())) {
				System.out.println("Mat khau phai tu 6 - 12 ki tu, co it nhat 1 ki tu viet hoa");
				return;
			} else stmt.setString(3, user.getPassword());
			
			stmt.setString(4, role);
			if(user instanceof Admin) {
				stmt.setInt(5, ((Admin) user).getExplnYear());
				stmt.setNull(6, Types.VARCHAR);
			} else {
				stmt.setNull(5, Types.INTEGER);
				stmt.setString(6, ((Employee) user).getProSkill());
			}
			stmt.executeUpdate();
			System.out.println("Them nguoi dung thanh cong!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void printAllUsers() {
		String sql = "SELECT id, full_name, email FROM users";
		try (Connection con = DatabaseManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			System.out.println("ID | Full Name | Email");
			while(rs.next()) {
				System.out.println(rs.getInt("id") + " | "
				+ rs.getString("full_name") + " | "
				+ rs.getString("email"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void printUserById(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		try(Connection con = DatabaseManager.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Full Name: " + rs.getString("full_name"));
                System.out.println("Email: " + rs.getString("email"));
			} else {
				System.out.println("Khong tim thay nguoi dung!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUserById(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Xoa nguoi dung thanh cong!");
            } else {
                System.out.println("Khong tim thay nguoi dung!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public boolean login(String email, String password) {
		String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
		try (Connection con = DatabaseManager.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setString(1, email);
				stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();
				return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void createEmployee(String fullName, String email) {
		if (!validateEmail(email)) {
			System.out.println("Loi email khong dung dinh dang");
			return;
		}
		if (!validateFullName(fullName)) {
			System.out.println("Ten day du chi duoc chua chu cai va dau cach");
			return;
		}
		String sql = "INSERT INTO users (full_name, email, password, role) VALUES (?, ?, ?, ?)";
		try (Connection con = DatabaseManager.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, fullName);
			stmt.setString(2, email);
			stmt.setString(3, "123456");
			stmt.setString(4, "Employee");
			stmt.executeUpdate();
			System.out.println("Tao nhan vien thanh cong!");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
