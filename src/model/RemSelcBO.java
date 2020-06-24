package model;

import DAO.RemSelcDAO;
import beans.Remind;

public class RemSelcBO {
	public Remind execute(Remind ID) { //一意のリマインドの取得処理
		RemSelcDAO dao = new RemSelcDAO();
		return dao.selectOne(ID);
	}
}
