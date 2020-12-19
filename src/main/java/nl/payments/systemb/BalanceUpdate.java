package nl.payments.systemb;

import nl.payments.model.AccountInfo;
import nl.payments.repo.AccountInfoRepo;

public class BalanceUpdate {

    private static AccountInfoRepo accountInfoRepo = AccountInfoRepo.getInstance();

    public static AccountInfo updateBalance(AccountInfo accountInfo) throws Exception {
        return accountInfoRepo.update(accountInfo);
    }

}
