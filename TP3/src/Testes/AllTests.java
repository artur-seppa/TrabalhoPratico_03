package Testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
//Teste
@RunWith(Suite.class)
@SuiteClasses({ TesteCadastroItens.class, TesteDoFormatador.class })
public class AllTests {

}
