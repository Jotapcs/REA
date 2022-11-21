package br.senac.BackEnd.Reserva;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("reserva")
public class DadosDaReservaService {


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(DadosDaReserva dadosDaReserva) {
		try {
			DadosDaReservaJDBC.cadastroReserva(dadosDaReserva);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DadosDaReserva> listar(){
		try {
			return DadosDaReservaJDBC.exibirReserva();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(DadosDaReserva dadosDaReserva) {
		try {
			DadosDaReservaJDBC.editarReserva(dadosDaReserva);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(DadosDaReserva dadosDaReserva) {
		try {
			DadosDaReservaJDBC.deletarReserva(dadosDaReserva);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

