package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import beans.Remind;
import beans.User;

public class RemSortDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/interfacerobot?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public Set<Remind> findCategory(User loginUser) { //カテゴリ一覧の取得
		//空のHashSetを用意(SQL文にも重複排除のDISTINCTをかけているが、念のためコレクションも重複排除のHashSetを使用している)
		Set<Remind> categoryList = new HashSet<>();
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SQL文(カテゴリの重複排除)
			String sql = "SELECT DISTINCT CATEGORY FROM REMIND WHERE USERID = ? ORDER BY ID DESC";
			//SQL文送信
			PreparedStatement pStmt = con.prepareStatement(sql);
			//SQL文に情報を渡す
			pStmt.setString(1, loginUser.getID());
			//実行結果取得
			ResultSet rs = pStmt.executeQuery();
			//取得結果の繰り返し処理
			while(rs.next()) {
				//取得結果をHashSetに格納
				String category = rs.getString("CATEGORY");
				Remind categoryPiece = new Remind(category);
				categoryList.add(categoryPiece);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return categoryList;
	}//findCategory()

	public List<Remind> sort(User loginUser, String specifiedCategory) { //カテゴリでソート処理
		//空のArrayListの用意
		List<Remind> remSortList = new ArrayList<>();
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SQL文
			String sql = "SELECT ID, USERID, REMIND, CATEGORY FROM REMIND WHERE USERID = ? AND CATEGORY = ? ORDER BY ID DESC";
			//SQL文送信
			PreparedStatement pStmt = con.prepareStatement(sql);
			//SQL文に情報を渡す
			pStmt.setString(1, loginUser.getID());
			pStmt.setString(2, specifiedCategory);
			//実行結果取得
			ResultSet rs = pStmt.executeQuery();
			//取得結果の繰り返し処理
			while(rs.next()) {
				//取得結果をArrayListに格納
				int ID = rs.getInt("ID");
				String userID = rs.getString("USERID");
				String remind = rs.getString("REMIND");
				String category = rs.getString("CATEGORY");
				Remind reminder = new Remind(ID, userID, remind, category);
				remSortList.add(reminder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return remSortList;
	}//sort()
}
