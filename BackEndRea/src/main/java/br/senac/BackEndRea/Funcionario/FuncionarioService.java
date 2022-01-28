package br.senac.BackEndRea.Funcionario;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("funcionario")
public class FuncionarioService {


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Funcionario funcionario) {
		try {
			FuncionarioJDBC.cadastroFuncionario(funcionario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Funcionario> listar(){
		try {
			return FuncionarioJDBC.exibirFuncionairo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Funcionario funcionario) {
		try {
			FuncionarioJDBC.editarFuncionario(funcionario);;;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(Funcionario funcionario) {
		try {
			FuncionarioJDBC.deletarFuncionario(funcionario);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

