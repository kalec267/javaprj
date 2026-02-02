package d260202_02;

import java.util.List;

public class AccountbookManager {
	AccountbookDAO dao;
	
	public AccountbookManager(AccountbookDAO dao) {
		this.dao=dao;
	}
	
	public void selectByCategory(String category) {
		System.out.println(dao.findByCategory(category));
	}
}
