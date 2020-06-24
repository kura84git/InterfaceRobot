package model;

import java.util.List;
import java.util.Set;

import DAO.RemSortDAO;
import beans.Remind;
import beans.User;

public class RemSortBO {
	public Set<Remind> findCategory(User loginUser) { //カテゴリ検索処理
		RemSortDAO dao = new RemSortDAO();
		return dao.findCategory(loginUser);
	}

	public List<Remind> sort(User loginUser, String specifiedCategory) { //カテゴリのソートでリマインドを取得する処理
		RemSortDAO dao = new RemSortDAO();
		return dao.sort(loginUser, specifiedCategory);
	}

}
