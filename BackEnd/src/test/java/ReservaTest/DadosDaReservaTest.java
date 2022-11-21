package ReservaTest;

import br.senac.BackEnd.Reserva.DadosDaReserva;

import java.util.ArrayList;
import java.util.List;

public class DadosDaReservaTest {

    public static DadosDaReserva dadosDaReservaTest(){

        DadosDaReserva dadosDaReserva = new DadosDaReserva();
        dadosDaReserva.setId(1);
        dadosDaReserva.setNome("Joao Pedro");
        dadosDaReserva.setCpf("1234567981");
        dadosDaReserva.setRg("1234657489");
        dadosDaReserva.setTelefone("11958694890");
        dadosDaReserva.setEmail("test@hotmail.com");
        dadosDaReserva.setDataNascimento("19/08/2002");
        dadosDaReserva.setDataCheckin("11/12/2022");
        dadosDaReserva.setDataCheckout("15/12/2022");
        dadosDaReserva.setNumeroAcompanhantes(5);

        return dadosDaReserva;
    }

    public static DadosDaReserva dadosDaReservaTestNull(){

        DadosDaReserva dadosDaReserva = new DadosDaReserva();
        return dadosDaReserva;
    }

    public static List<DadosDaReserva> listDadosDaReservaTest(){
        DadosDaReserva dadosDaReserva = new DadosDaReserva();
        dadosDaReserva.setId(1);
        dadosDaReserva.setNome("Joao Pedro");
        dadosDaReserva.setCpf("1234567981");
        dadosDaReserva.setRg("1234657489");
        dadosDaReserva.setTelefone("11958694890");
        dadosDaReserva.setEmail("test@hotmail.com");
        dadosDaReserva.setDataNascimento("19/08/2002");
        dadosDaReserva.setDataCheckin("11/12/2022");
        dadosDaReserva.setDataCheckout("15/12/2022");
        dadosDaReserva.setNumeroAcompanhantes(5);

        List<DadosDaReserva> dadosDaReservaList = new ArrayList<>();
        dadosDaReservaList.add(dadosDaReserva);

        return dadosDaReservaList;
    }
}
