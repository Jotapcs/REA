package br.senac.BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

	public static Connection connect() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi", "root", "");
	}

	public static void main(String []args) throws Exception{
		connect();
	}

}
