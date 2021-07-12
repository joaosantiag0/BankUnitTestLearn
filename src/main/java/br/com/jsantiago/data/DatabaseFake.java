package br.com.jsantiago.data;

import br.com.jsantiago.exceptions.AccountException;
import br.com.jsantiago.models.Account;

import java.util.ArrayList;
import java.util.List;

public class DatabaseFake {

    private List<Account> accounts = new ArrayList<>();

    public void saveAccount(Account account) throws AccountException {
        if(accounts.size() > 0){
            boolean clientAlreadyHaveAccount = accounts.stream().anyMatch(x -> x.getCpf() == account.getCpf());
            if(clientAlreadyHaveAccount)
                throw new AccountException("Client already have a account");
        }

        accounts.add(account);
    }
}
