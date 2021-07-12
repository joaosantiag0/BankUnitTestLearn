package data;

import br.com.jsantiago.data.DatabaseFake;
import br.com.jsantiago.exceptions.AccountException;
import br.com.jsantiago.models.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseFakeTest {

    @Test
    public void shouldSaveAccountReturnExceptionIfCpfAlreadySavedInAnotherAccount(){
        float cpf = 11111111111f;
        DatabaseFake databaseFake = new DatabaseFake();
        String name = "Joao";
        Account account = Account.newInstance(name, cpf);

        Assertions.assertDoesNotThrow(() -> databaseFake.saveAccount(account));
        Assertions.assertThrows(AccountException.class, () -> databaseFake.saveAccount(account));
    }
}
