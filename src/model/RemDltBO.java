package model;

import DAO.RemDltDAO;
import beans.Remind;

public class RemDltBO {
	public boolean execute(Remind remDlt) { //リマインド削除処理
		RemDltDAO dao = new RemDltDAO();
		return dao.delete(remDlt);
	}
}
