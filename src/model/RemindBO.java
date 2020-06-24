package model;

import java.util.List;

import DAO.RemindDAO;
import beans.Remind;
import beans.User;

public class RemindBO {
	public List<Remind> select(User loginUser) { //リマインドの一覧取得
		RemindDAO dao = new RemindDAO();
		List<Remind> remindList = dao.selectRemind(loginUser);
		return remindList;
	}

	public boolean insert(Remind remindLatest) { //リマインドの新規登録
		RemindDAO dao = new RemindDAO();
		boolean isInsert = dao.insertRemind(remindLatest);
		return isInsert;
	}

}
