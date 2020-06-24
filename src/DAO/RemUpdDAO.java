package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Remind;

public class RemUpdDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/interfacerobot?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public boolean update(Remind remUpd) { //リマインドの書き換え処理
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SQL文
			String sql = "UPDATE REMIND SET REMIND = ?, CATEGORY= ? WHERE ID = ? AND USERID = ? ";
			//SQL文送信
			PreparedStatement pStmt = con.prepareStatement(sql);
			//SQL文に情報を渡す
			pStmt.setString(1, remUpd.getRemind());
			pStmt.setString(2, remUpd.getCategory());
			pStmt.setInt(3, remUpd.getID());
			pStmt.setString(4, remUpd.getUserID());
			//実行結果取得
			int rs = pStmt.executeUpdate();
			//実行できなかった場合
			if(rs != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		//実行できた場合
		return true;
	} //update()
}
