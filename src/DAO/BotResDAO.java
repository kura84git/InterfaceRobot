package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.ComResPath;
import beans.User;

public class BotResDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/InterfaceRobot?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS ="root";

	public String selectRes(int resID) {
		String response = null;
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT response FROM BOTRESPONSE where ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//?に情報を渡す
			pStmt.setInt(1, resID);
			//select実行
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				response = rs.getString("response");
				return response;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return response;
		}
		return response;
	}

	public boolean insertResponse(User loginUser, ComResPath comres, int resID) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "INSERT INTO BotResponse(id, userID, response) VALUES(?, ?, ?)";
			//SQLを送る
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//?に情報を渡す
			int newResID = resID + 1;
			pStmt.setInt(1, newResID);
			pStmt.setString(2, loginUser.getID());
			pStmt.setString(3, comres.getRes());
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

}
