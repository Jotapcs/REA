package ReservaTest;

import br.senac.BackEnd.Reserva.DadosDaReserva;
import br.senac.BackEnd.Reserva.DadosDaReservaJDBC;
import org.junit.Test;
import static org.mockito.Mockito.when;

public class DadosDaReservaServiceTest {

    @Test
    public void listarTest() throws Exception {
        DadosDaReservaJDBC.exibirReserva();
    }

    @Test(expected = Exception.class)
    public void listarTestException() throws Exception {
        when(DadosDaReservaJDBC.exibirReserva()).thenReturn(DadosDaReservaTest.listDadosDaReservaTest());
    }

    @Test
    public void inserirTest() throws Exception {
        DadosDaReservaJDBC.cadastroReserva(DadosDaReservaTest.dadosDaReservaTest());
    }

    @Test(expected = Exception.class)
    public void inserirTestException() throws Exception {
        DadosDaReservaJDBC.cadastroReserva((DadosDaReserva) DadosDaReservaTest.listDadosDaReservaTest());
    }

    @Test
    public void atualizarTest() throws Exception{
        DadosDaReservaJDBC.editarReserva(DadosDaReservaTest.dadosDaReservaTest());
    }

    @Test(expected = Exception.class)
    public void atualizarTestException() throws Exception{
        DadosDaReservaJDBC.editarReserva((DadosDaReserva) DadosDaReservaTest.listDadosDaReservaTest());
    }

    @Test
    public void excluirTest() throws Exception{
        DadosDaReservaJDBC.deletarReserva(DadosDaReservaTest.dadosDaReservaTest());
    }

    @Test(expected = Exception.class)
    public void excluirTestException() throws Exception{
        DadosDaReservaJDBC.deletarReserva((DadosDaReserva) DadosDaReservaTest.listDadosDaReservaTest());
    }
}
