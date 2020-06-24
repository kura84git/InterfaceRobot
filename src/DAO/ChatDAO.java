package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Chat;

public class ChatDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/InterfaceRobot?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS ="root";
	public List<Chat> getChat(List<Integer> matchID) {
		List<Chat> chatList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "select Chat.id, Chat.friendID, Account.name, Chat.chat from Chat"
					+ " join Account on Chat.userID = Account.id where Chat.friendID = ? or Chat.friendID = ? order by Chat.id DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//?に情報を渡す
			pStmt.setInt(1, matchID.get(0));
			pStmt.setInt(2, matchID.get(1));
			//select実行
			ResultSet rs = pStmt.executeQuery();
			//結果をArrayListに格納
			while(rs.next()) {
				int id = rs.getInt("Chat.id");
				int friendID = rs.getInt("friendID");
				String name = rs.getString("Account.name");
				String chat = rs.getString("Chat.chat");
				Chat c = new Chat(id, friendID, name, chat);
				chatList.add(c);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return chatList;
	}
	public boolean postChat(Chat c) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "INSERT INTO Chat(friendID, userID, chat) VALUES(?, ?, ?)";
			//SQLを送る
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//?に情報を渡す
			pStmt.setInt(1, c.getFriendID());
			pStmt.setString(2, c.getUserID());
			pStmt.setString(3, c.getChat());
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
