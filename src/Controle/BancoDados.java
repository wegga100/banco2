package Controle;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Model.Cliente;
import Model.Produtos;
import Model.Seccao;

public class BancoDados {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet= null;
	
	public void conectar(){
		String servidor = "jdbc:mysql://localhost:3306/fbd_grafica?useSSL=false";
		String usuario = "root";
		String senha ="1234";
		String drive ="com.mysql.jdbc.Driver";
		
		try {
			Class.forName(drive);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("erro ao conec "+e);
			JOptionPane.showMessageDialog(null, "Erro ao gravar /n"+e);
		}
	}	
	public boolean estaConectado(){
	
		if(this.connection != null){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public void gravarCliente(Cliente cliente){
		 String query = "insert into cliente (nome,tipo,telefone) values('"+cliente.getNome()+"',"+cliente.getTipo()+",'"+cliente.getTelefone()+"');";
		try {
			 String queryTemp= "insert into cliente (nome,tipo,telefone) values('"+cliente.getNome()+"',"+cliente.getTipo()+",'"+cliente.getTelefone()+"');";
			 this.statement.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	

	public void gravarSeccao(Seccao sec){
		
		String query = "insert into seccao (nome,descricao) values('"+sec.getNome()+"',"+sec.getDescricao()+"');";
		try {
				 this.statement.executeUpdate(query);
		} catch (SQLException e) {
				System.out.println(e);
		}
		query  = null;
		
	}
		
	
	
	public static void main(String[] args) {
		 BancoDados b =new BancoDados();
		 b.conectar();
		 if(b.estaConectado()){
			 System.out.println("sim");
		 }
		 else{
			 System.out.println("nao");
		 }
		
	}
	
}
