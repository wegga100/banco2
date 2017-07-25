package Controle;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Model.Cliente;
import Model.Empregado;
import Model.Pedido;
import Model.Produtos;
import Model.Seccao;
import Model.Venda;

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
		
		try {
			 String query= "insert into cliente (nome,tipo,telefone) values('"+cliente.getNome()+"',"+cliente.getTipo()+",'"+cliente.getTelefone()+"');";
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
	
	
	public void gravarProdutos(Produtos prod){
		
		String query = "insert into Produto (nome,cod_Barras,validade,preço,quant_estoque,descrição,id_seccao) "
				+ "values('"+prod.getNome()+"','"+prod.getCodBarras()+"','"+prod.getDataValidade()+"','"+prod.getPreco()+"','"+prod.getQuantEstoque()+"','"+prod.getDescricao()+"','"+prod.getIdSeccao()+"')";
		try {
				 this.statement.executeUpdate(query);
		} catch (SQLException e) {
				System.out.println(e);
		}
		query  = null;
		
	}	

	
	public void gravarEmpregado(Empregado emp){
		try {
			 String query = "insert into empregado (nome,tipo,telefone,matricula,senha) values('"+emp.getNome()+"',"+emp.getTipo()+",'"+emp.getTelefone()+"','"+emp.getMatricula()+"','"+emp.getSenha()+");";
			 this.statement.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println(e);
			}
	}
	
	public void gravarPedido(Pedido ped){
		try {
			 String query = "insert into pedido(valor-total,id_Cliente) values('"+ped.getValorTotal()+"','"+ped.getIdCliente()+"');";
			 this.statement.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println(e);
			}
	}

	public void gravarContemEmPedido(int idProduto, int idPedido, int quantidade){
		try {
			 String query = "insert into Contem_pedido(id-pedido,id-produto,quantidade) values('"+idPedido+"','"+idProduto+"','"+quantidade+"');";
			 this.statement.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println(e);
			}
	}
	public void gravarVenda(Venda venda){
		try {
			 String query = "insert into Venda(Forma_pagamento,data,id_Empregado,id_Pedido) values('"+venda.getFormaPagamento()+"','"+venda.getData()+"','"+venda.getIdEmpregado()+"','"+venda.getPedido().getId()+"');";
			 this.statement.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println(e);
			}
	}
}






















