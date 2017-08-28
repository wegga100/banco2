package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Model.Cliente;

public class Conect {


	 Connection connection = null;
	 Statement statement = null;
	 ResultSet resultSet;
	 ResultSet resultSetDois =  null;
	
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

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public ResultSet getResultSetDois() {
		return resultSetDois;
	}

	public void setResultSetDois(ResultSet resultSetDois) {
		this.resultSetDois = resultSetDois;
	}


	
}
