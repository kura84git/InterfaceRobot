package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Remind;

public class RemSelcDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/interfacerobot?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public Remind selectOne(Remind id) { //一意のリマインドの取得処理
		Remind remUpd = null;
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SQL文の送信
			String sql = "SELECT REMIND, CATEGORY FROM REMIND WHERE ID = ? AND USERID = ?";
			//SQL文送信
			PreparedStatement pStmt = con.prepareStatement(sql);
			//SQL文に情報を渡す
			pStmt.setInt(1, id.getID());
			pStmt.setString(2, id.getUserID());
			//実行結果取得
			ResultSet rs = pStmt.executeQuery();
			//情報を取得できた場合
			if(rs.next()) {
				String remind = rs.getString("REMIND");
				String category = rs.getString("CATEGORY");
				remUpd = new Remind(id.getID(), id.getUserID(), remind, category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return remUpd;
	}//selectOne()

}
