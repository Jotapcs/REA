package br.senac.BackEnd.Reserva;

import br.senac.BackEnd.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DadosDaReservaJDBC {

	public static void cadastroReserva(DadosDaReserva dadosDaReserva) throws Exception {
		
		String sql = "INSERT INTO reserva(nome, cpf, rg, telefone, email, dataNascimento, dataCheckin, dataCheckout, numeroAcompanhantes) VALUES (?,?,?,?,?,?,?,?,?);";
		
		try (PreparedStatement ps = DataBase.connect().prepareStatement(sql)) {
			ps.setString(1, dadosDaReserva.getNome());
			ps.setString(2, dadosDaReserva.getCpf());
			ps.setString(3, dadosDaReserva.getRg());
			ps.setString(4, dadosDaReserva.getTelefone());
			ps.setString(5, dadosDaReserva.getEmail());
			ps.setString(6, dadosDaReserva.getDataNascimento());
			ps.setString(7, dadosDaReserva.getDataCheckin());
			ps.setString(8, dadosDaReserva.getDataCheckout());
			ps.setInt(9, dadosDaReserva.getNumeroAcompanhantes());
			
			ps.execute();
		}
	}
	
	public static List<DadosDaReserva> exibirReserva() throws Exception {
		
		String sql = "SELECT * FROM reserva";
		
		List<DadosDaReserva> resultados = new ArrayList<DadosDaReserva>();
		
		try (PreparedStatement ps = DataBase.connect().prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				DadosDaReserva dadosDaReserva = new DadosDaReserva();

				dadosDaReserva.setId(rs.getInt("id"));
				dadosDaReserva.setNome(rs.getString("nome"));
				dadosDaReserva.setCpf(rs.getString("cpf"));
				dadosDaReserva.setRg(rs.getString("rg"));
				dadosDaReserva.setTelefone(rs.getString("telefone"));
				dadosDaReserva.setEmail(rs.getString("email"));
				dadosDaReserva.setDataNascimento(rs.getString("dataNascimento"));
				dadosDaReserva.setDataCheckin(rs.getString("dataCheckin"));
				dadosDaReserva.setDataCheckout(rs.getString("dataCheckout"));
				dadosDaReserva.setNumeroAcompanhantes(rs.getInt("numeroAcompanhantes"));
				
				resultados.add(dadosDaReserva);
			}
		}
		return resultados;
	}
	
	public static void editarReserva(DadosDaReserva dadosDaReserva) throws Exception {
		String sql = "UPDATE reserva SET nome = ?, cpf = ?, rg = ?, telefone = ?, email = ?, dataNascimento = ?, dataCheckin = ?, dataCheckout = ?, numeroAcompanhantes = ? WHERE id = ?;";
		
		//try-with-resources
		try (PreparedStatement ps = DataBase.connect().prepareStatement(sql)){
			ps.setString(1, dadosDaReserva.getNome());
			ps.setString(2, dadosDaReserva.getCpf());
			ps.setString(3, dadosDaReserva.getRg());
			ps.setString(4, dadosDaReserva.getTelefone());
			ps.setString(5, dadosDaReserva.getEmail());
			ps.setString(6, dadosDaReserva.getDataNascimento());
			ps.setString(7, dadosDaReserva.getDataCheckin());
			ps.setString(8, dadosDaReserva.getDataCheckout());
			ps.setInt(9, dadosDaReserva.getNumeroAcompanhantes());
			ps.setInt(10, dadosDaReserva.getId());
			
			ps.execute();
		}
	}
	
	public static void deletarReserva(DadosDaReserva dadosDaReserva) throws Exception {
		String sql = "DELETE FROM reserva WHERE id = ?;";
		
		//try-with-resources
		try (PreparedStatement ps = DataBase.connect().prepareStatement(sql)){
			ps.setInt(1, dadosDaReserva.getId());
			
			ps.execute();
		}
		
	}
}
