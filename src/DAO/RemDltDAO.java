package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Remind;

public class RemDltDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/interfacerobot?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public boolean delete(Remind remDlt) { //リマインドの削除処理
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SQL文
			String sql = "DELETE FROM REMIND WHERE ID = ? AND USERID = ? ";
			//SQL文送信
			PreparedStatement pStmt = con.prepareStatement(sql);
			//SQL文に情報を渡す
			pStmt.setInt(1, remDlt.getID());
			pStmt.setString(2, remDlt.getUserID());
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
