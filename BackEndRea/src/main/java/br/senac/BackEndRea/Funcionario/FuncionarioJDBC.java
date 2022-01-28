package br.senac.BackEndRea.Funcionario;

import br.senac.BackEndRea.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioJDBC {

	public static void cadastroFuncionario(Funcionario funcionario) throws Exception {
		
		String sql = "INSERT INTO funcionario(nome, cpf, rg, telefone, email, dataNascimento, dataContrato, funcao, numeroContrato) VALUES (?,?,?,?,?,?,?,?,?);";
		
		try (PreparedStatement ps = DataBase.connect().prepareStatement(sql)) {
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getCpf());
			ps.setString(3, funcionario.getRg());
			ps.setString(4, funcionario.getTelefone());
			ps.setString(5, funcionario.getEmail());
			ps.setString(6, funcionario.getDataNascimento());
			ps.setString(7, funcionario.getDataContrato());
			ps.setString(8, funcionario.getFuncao());
			ps.setInt(9, funcionario.getNumeroContrato());
			
			ps.execute();
		}
	}
	
	public static List<Funcionario> exibirFuncionairo() throws Exception {
		
		String sql = "SELECT * FROM funcionario";
		
		List<Funcionario> resultados = new ArrayList<Funcionario>();
		
		try (PreparedStatement ps = DataBase.connect().prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Funcionario funcionario = new Funcionario();

				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setRg(rs.getString("rg"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setDataNascimento(rs.getString("dataNascimento"));
				funcionario.setDataContrato(rs.getString("dataContrato"));
				funcionario.setFuncao(rs.getString("Funcao"));
				funcionario.setNumeroContrato(rs.getInt("numeroContrato"));
				
				resultados.add(funcionario);
			}
		}
		return resultados;
	}
	
	public static void editarFuncionario(Funcionario funcionario) throws Exception {
		String sql = "UPDATE funcionario SET nome = ?, cpf = ?, rg = ?, telefone = ?, email = ?, dataNascimento = ?, dataContrato = ?, funcao = ?, numeroContrato = ? WHERE id = ?;";
		
		//try-with-resources
		try (PreparedStatement ps = DataBase.connect().prepareStatement(sql)){
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getCpf());
			ps.setString(3, funcionario.getRg());
			ps.setString(4, funcionario.getTelefone());
			ps.setString(5, funcionario.getEmail());
			ps.setString(6, funcionario.getDataNascimento());
			ps.setString(7, funcionario.getDataContrato());
			ps.setString(8, funcionario.getFuncao());
			ps.setInt(9, funcionario.getNumeroContrato());
			ps.setInt(10, funcionario.getId());
			
			ps.execute();
		}
	}
	
	public static void deletarFuncionario(Funcionario funcionario) throws Exception {
		String sql = "DELETE FROM funcionario WHERE id = ?;";
		
		//try-with-resources
		try (PreparedStatement ps = DataBase.connect().prepareStatement(sql)){
			ps.setInt(1, funcionario.getId());
			
			ps.execute();
		}
		
	}
}
