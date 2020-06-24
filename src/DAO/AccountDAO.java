package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;

public class AccountDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/InterfaceRobot?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS ="root";
	public boolean insertUser(User user) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "INSERT INTO ACCOUNT(ID, PASS, NAME, MAIL, BOTNAME) VALUES(?, ?, ?, ?, ?)";
			//SQLを送る
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//?に情報を渡す
			pStmt.setString(1, user.getID());
			pStmt.setString(2, user.getPass());
			pStmt.setString(3, user.getName());
			pStmt.setString(4, user.getMail());
			pStmt.setString(5, user.getBotName());
			//insert実行
			int result = pStmt.executeUpdate();
			//.executeUpdateは戻り値としていくつの処理を実行できたかを返す
			//今回insertは一度だけしか実行していないため成功なら１を返す
			if (result != 1) {
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public User selectUser(User user) {
		User account = null;
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT * FROM ACCOUNT WHERE ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getID());
			pStmt.setString(2, user.getPass());
			//select実行
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				String ID = rs.getString("ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				String mail =rs.getString("MAIL");
				String botName = rs.getString("botName");
				account = new User(ID, pass, name, mail, botName);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return account;
	}
	public User searchFriend(String friendID, String friendBotName) {
		User friend = null;
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT * FROM ACCOUNT WHERE ID = ? AND BOTNAME = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, friendID);
			pStmt.setString(2, friendBotName);
			//select実行
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				String ID = rs.getString("ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				String mail =rs.getString("MAIL");
				String botName = rs.getString("botName");
				friend = new User(ID, pass, name, mail, botName);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return friend;
	}
	public List<User> getFriends(User loginUser) {
		List<User> friendList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "select A.id, A.name, A.pass, A.mail, A.BotName from account as A "
					+ "join (select friendID from friend where userID = ?) as F on A.id = F.friendID";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginUser.getID());
			//select実行
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				String ID = rs.getString("id");
				String name = rs.getString("name");
				String pass = rs.getString("pass");
				String mail =rs.getString("mail");
				String botName = rs.getString("BotName");
				User friend = new User(ID, pass, name, mail, botName);
				friendList.add(friend);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return friendList;
	}
	public boolean updateUser(User loginUser, User user) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "UPDATE ACCOUNT SET ID=?, NAME=?, PASS=?, MAIL=?, BOTNAME=? WHERE ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getID());
			pStmt.setString(2, user.getName());
			pStmt.setString(3, user.getPass());
			pStmt.setString(4, user.getMail());
			pStmt.setString(5, user.getBotName());
			pStmt.setString(6, loginUser.getID());
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public User selectMail(User user) {
		User account = null;
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT * FROM ACCOUNT WHERE MAIL = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// ID means MAIL
			pStmt.setString(1, user.getID());
			pStmt.setString(2, user.getPass());
			//select実行
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				String ID = rs.getString("ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				String mail =rs.getString("MAIL");
				String botName = rs.getString("botName");
				account = new User(ID, pass, name, mail, botName);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return account;
	}

}
