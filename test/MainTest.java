import br.com.jsantiago.Main;
import br.com.jsantiago.exceptions.ClientNameException;
import br.com.jsantiago.exceptions.CpfInvalidException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {

    @Test
    public void test_shouldMenuReturnExceptionIfUserNotInputInt(){
        ByteArrayInputStream in = new ByteArrayInputStream("test".getBytes());
        System.setIn(in);

        assertThrows(NumberFormatException.class, Main::menu);
    }

    @Test
    public void test_shouldMenuReturnExceptionIfOptionIsLessThanZero(){
        ByteArrayInputStream in = new ByteArrayInputStream(("-1").getBytes());
        System.setIn(in);

        assertThrows(IndexOutOfBoundsException.class, Main::menu);
    }

    @Test
    public void test_shouldAbrirContaValidateNameContainsSpace(){
        ByteArrayInputStream in = new ByteArrayInputStream("joao".getBytes());
        System.setIn(in);

        assertThrows(ClientNameException.class, Main::abrirConta, "Name not contains space");
    }

    @Test
    public void test_shouldAbrirContaValidateCpfIsNumericAndElevenDigits(){
        ByteArrayInputStream in = new ByteArrayInputStream("Joao Santiago \n 111.11".getBytes());
        System.setIn(in);

        assertThrows(CpfInvalidException.class, Main::abrirConta);
    }
}
