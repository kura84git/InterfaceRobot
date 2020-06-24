package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BotAction;
import beans.ComResPath;
import beans.User;

public class BotActionDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/InterfaceRobot?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS ="root";

	public List<BotAction> getAction(User loginUser) {
		 List<BotAction> actionList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT resID, action  FROM BotAction WHERE userID is NULL OR userID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//?に情報を渡す
			pStmt.setString(1, loginUser.getID());
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int resID = rs.getInt("resID");
				String action = rs.getString("action");
				BotAction botAction = new BotAction(resID, action);
				actionList.add(botAction);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return actionList;
	}

	public int selectAction(String command) {
		int resID = 0;
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT resID FROM botAction WHERE action = ? AND userID is NULL";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//?に情報を渡す
			pStmt.setString(1, command);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				resID = rs.getInt("resID");
			}
		}catch(SQLException e){
			e.printStackTrace();
			return resID;
		}
		return resID;
	}

	public boolean insertAction(User loginUser, ComResPath comres, int resID) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "INSERT INTO BotAction(userID, resID, action) VALUES(?, ?, ?)";
			//SQLを送る
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//?に情報を渡す
			int newResID = resID + 1;
			pStmt.setString(1, loginUser.getID());
			pStmt.setInt(2, newResID);
			pStmt.setString(3, comres.getCom());
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

	public int getResID() {
		int resID = 0;
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT resID FROM botAction order by resID DESC limit 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				resID = rs.getInt("resID");
			}
		}catch(SQLException e){
			e.printStackTrace();
			return resID;
		}
		return resID;
	}

	public int selectMyAction(User loginUser, String command) {
		int resID = 0;
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT resID FROM botAction WHERE action = ? AND userID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//?に情報を渡す
			pStmt.setString(1, command);
			pStmt.setString(2, loginUser.getID());
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				resID = rs.getInt("resID");
			}
		}catch(SQLException e){
			e.printStackTrace();
			return resID;
		}
		return resID;
	}
}
