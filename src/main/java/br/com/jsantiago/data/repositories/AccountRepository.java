package br.com.jsantiago.data.repositories;

import br.com.jsantiago.data.DatabaseFake;
import br.com.jsantiago.exceptions.AccountException;
import br.com.jsantiago.models.Account;

public class AccountRepository {

    private DatabaseFake databaseFake;

    public AccountRepository() {
        databaseFake = new DatabaseFake();
    }

    public void saveAccount(Account account) throws AccountException {
        databaseFake.saveAccount(account);
    }
}
