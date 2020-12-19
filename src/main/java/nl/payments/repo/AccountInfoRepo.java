package nl.payments.repo;

import nl.payments.model.AccountInfo;
import java.util.Map;
import java.util.Hashtable;

public class AccountInfoRepo{
	
	Map<String, AccountInfo> dbTable = new Hashtable<String, AccountInfo> ();
	
	private static AccountInfoRepo accountInfoRepo;
	
	private AccountInfoRepo() {
	}
	
	public static AccountInfoRepo getInstance() {
		if (accountInfoRepo == null) {
			accountInfoRepo = new AccountInfoRepo();
		}
		return accountInfoRepo;
	}
	
	public void save(AccountInfo accountInfo) {
		dbTable.put(accountInfo.getId(), accountInfo);
	}
	
	public AccountInfo update(AccountInfo accountInfo) {
		if(dbTable.containsKey(accountInfo.getId())) {
			return dbTable.replace(accountInfo.getId(), accountInfo);
		}
		return null;
	}
	
	public AccountInfo find (String id) {
		if(dbTable.containsKey(id)) {
			return dbTable.get(id);
		}
		return null;
	}
}


