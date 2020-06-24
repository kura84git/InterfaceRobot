package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Command;
import beans.User;

public class CommandDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/InterfaceRobot?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS ="root";

	public boolean insertCommand(Command com) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "INSERT INTO COMMAND(name, command) VALUES(?, ?)";
			//SQLを送る
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//?に情報を渡す
			pStmt.setString(1, com.getName());
			pStmt.setString(2, com.getCommand());
			//insert実行
			int result = pStmt.executeUpdate();
			//.executeOpdateは戻り値としていくつの処理を実行できたかを返す
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

	public List<Command> selectCommand(User loginUser) {
		List<Command> commandList = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT ID,name,command FROM COMMAND where name = ? or name = ? ORDER BY ID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//?に情報を渡す
			pStmt.setString(1, loginUser.getName());
			pStmt.setString(2, loginUser.getBotName());
			//select実行
			ResultSet rs = pStmt.executeQuery();
			//結果をArrayListに格納
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("name");
				String command = rs.getString("command");
				Command com = new Command(id, name, command);
				commandList.add(com);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return commandList;
	}
}
