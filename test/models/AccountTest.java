package models;

import br.com.jsantiago.models.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void test_shouldNewInstanceGenerateRandomAgencyNumberAndAccountNumber(){
        Account account = Account.newInstance("José da Silva", 11111111111f);

        Assertions.assertTrue(account.getAgencyNumber() > 0);
        Assertions.assertTrue(account.getAccountNumber() > 0);
    }
}
