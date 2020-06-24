package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;

public class FriendDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/InterfaceRobot?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS ="root";

	public boolean addFriend(User friend, User loginUser) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "INSERT INTO FRIEND(userID, friendID) VALUES(?, ?)";
			//SQLを送る
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//?に情報を渡す
			pStmt.setString(1, loginUser.getID());
			pStmt.setString(2, friend.getID());
			//insert実行
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Integer> findFriend(User loginUser, User friend) {
		List<Integer> matchID = new ArrayList<>();
		for(int i =0;i<3;i++) {
			matchID.add(0);
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT id FROM FRIEND "
					+ "WHERE (userID = ? AND friendID = ?) or (userID = ? AND friendID = ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginUser.getID());
			pStmt.setString(2, friend.getID());
			pStmt.setString(3, friend.getID());
			pStmt.setString(4, loginUser.getID());
			//select実行
			ResultSet rs = pStmt.executeQuery();
			int x = 0;
			while(rs.next()) {
				int num = rs.getInt("id");
				matchID.set(x, num);
				x++;
			}
			return matchID;
		}catch(SQLException e){
			e.printStackTrace();
			return matchID;
		}
	}
}
