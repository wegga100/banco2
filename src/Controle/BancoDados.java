package Controle;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import App.App;
import Model.Cliente;
import Model.Empregado;
import Model.Pedido;
import Model.Produtos;
import Model.Seccao;
import Model.Venda;

public class BancoDados {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet;
	private ResultSet resultSetDois =  null;
	
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
			System.err.println(e);
		}
	}
	
	public void gravarSeccao(Seccao sec){
		
		String query = "insert into seccao (nome,descricao) values('"+sec.getNome()+"','"+sec.getDescricao()+"');";
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
			 String query = "insert into empregado (nome,matricula,senha) values('"+emp.getNome()+"','"+emp.getMatricula()+"','"+emp.getSenha()+"');";
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

	public ArrayList<Cliente> pesquisarCliente(String nome){
		
		ArrayList<Cliente > clientes =  new ArrayList<>();
		try {
			String query = "select * from cliente where nome ='"+nome+"';";
			this.resultSet = this.statement.executeQuery(query);
			while (this.resultSet.next()){
				clientes.add(new Cliente(
						this.resultSet.getInt("id"),
						this.resultSet.getString("nome"), 
						this.resultSet.getInt("tipo"), 
						this.resultSet.getString("telefone")));
			}
			
			return clientes;
			
		} catch (SQLException e) {
			System.out.println("erro : "+e);
			e.printStackTrace();
		}
		return null;	
	}
	
	public Cliente pesquisarClienteId(int id){
		
		ArrayList<Cliente > clientes =  new ArrayList<>();
		try {
			String query = "select * from cliente where id='"+id+"'";
			statement= connection.prepareStatement(query);
			resultSet = statement.executeQuery(query);
			
			this.resultSet.next();
			
			int i = resultSet.getInt("id");
			
			
			Cliente c= new Cliente(
						i,
						resultSet.getString("nome"), 
						resultSet.getInt("tipo"), 
						resultSet.getString("telefone"));
			 System.out.println(c.getNome());
			 
			 return c;
			 
		} catch (SQLException e) {
			System.out.println("erro : "+e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;	
	}
	
	
	public ArrayList<Produtos> pesquisarProd(String nome){
		
		
		try {
			ArrayList<Produtos> produtos =  new ArrayList<>();
			String query = "select * from produto where nome ='"+nome+"';";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()){	
				produtos.add(new Produtos(
						this.resultSet.getInt("id"),
						this.resultSet.getString("nome"),
						this.resultSet.getNString("cod_barras"),
						this.resultSet.getString("validade"), 
						this.resultSet.getFloat("preço"), 
						this.resultSet.getInt("quant_estoque"),
						this.resultSet.getString("descrição"),
						this.resultSet.getInt("id_seccao")));
			}
			
			return produtos;
		} catch (SQLException e) {
			System.err.println("Erro : "+e);
			
		}
		
		
		return null;
	}

	public Produtos pesquisarProdCodigo(int cod_barras){
		
		
		try {
			
			String query = "select * from produto where cor_barras ='"+cod_barras+"';";
			this.resultSet = this.statement.executeQuery(query);
			return new Produtos(
						this.resultSet.getInt("id"),
						this.resultSet.getString("nome"),
						this.resultSet.getNString("cod_barras"),
						this.resultSet.getString("validade"), 
						this.resultSet.getFloat("preço"), 
						this.resultSet.getInt("quant_estoque"),
						this.resultSet.getString("descrição"),
						this.resultSet.getInt("id_seccao"));
			
		} catch (SQLException e) {
			System.err.println("Erro : "+e);
			
		}
		
		
		return null;
		
	}
	
	public void retirarDoEstoque(String cod_barras){
		
		String query = "update produto set quant_estoque = quant_estoque-1 where cod_barras = "+cod_barras+";";
		
		try {
			this.statement.executeQuery(query);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Pedido consultarPedido(int idPedido){
		
		Pedido pedido = new Pedido() ;
		pedido.setId(idPedido);
		
		try {
			String query =  "select *  from produto  as prod inner join pedido as ped inner join contem_pedido as cont on  cont.id_Pedido=ped.id  and  cont.id_produto=prod.id  where ped.id = '"+idPedido+"'; ";
			this.resultSetDois = this.statement.executeQuery(query);
			
			while(resultSetDois.next()){
				pedido.getProdNoCarrinho().add(App.banco.pesquisarProdCodigo(resultSetDois.getInt("cod_barras")));
				pedido.getQuantDeProd().add(resultSetDois.getInt("quantidade"));
				pedido.setValorTotal(pedido.getValorTotal()+(this.resultSetDois.getFloat("preço")*this.resultSetDois.getInt("quantidade")));
			}
			
			return pedido;
		} catch (SQLException e) {
			System.err.println("Erro : "+e);
			
		}
		
		return null;
	}
	
	public ArrayList<Venda> listarVendas(String data){
		
		ArrayList<Venda> vendas  =  new ArrayList<Venda>();
		
		try {
			String query =  "select *  from venda  as vend inner join pedido as ped inner join contem_pedido as cont on  vend.id_Pedido=ped.id  and  cont.id_pedido=ped.id  where vend.data = '"+data+"'; ";
			this.resultSet = this.statement.executeQuery(query);
			
			
			while(this.resultSet.next()){
				vendas.add( new Venda(this.resultSet.getInt("id"),
						new Pedido(this.resultSet.getInt(6), this.resultSet.getFloat("valor_total"), this.resultSet.getInt("id_cliente")), 
						this.resultSet.getString("data"), 
						this.resultSet.getInt("id_Empregado"), 
						this.resultSet.getInt("Forma_pagamento")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	public ArrayList<Seccao> pesquisarSeccao(String nome){
		
		ArrayList<Seccao> seccao = new ArrayList<>();
		String query =  "select *  from  seccao where nome = '%"+nome+"%';";
		try {
			this.resultSet = this.statement.executeQuery(query);
			
			while(this.resultSet.next()){
				seccao.add(new Seccao(
						
						this.resultSet.getInt("id"),
						this.resultSet.getString("nome"),
						this.resultSet.getString("descricao")));
			}
		
			return seccao;
			
		} catch (SQLException e) {
			System.err.println("Erro :  "+e);
			
		}
		
		return null;
	}

	public boolean validarLogin(String login, String senha){
		
	
		try {
			String query =  "select senha  from  empregado  where  nome = '"+login+"' ;";
			this.resultSet =  this.statement.executeQuery(query);
			if(!resultSet.next()){
				return false;
			}
			String s = this.resultSet.getString("senha");
			if(s.equals(senha)){
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			
			App.erro.mensagemErro("Erro ao realizar login");
		}	
		return false;
	}


}






















