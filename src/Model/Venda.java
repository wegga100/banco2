package Model;

import App.App;

public class Venda {
	
	private int id;
	private int idEmpregado;
	private String data;
	private int formaPagamento;
	private Pedido pedido;
	
	public Venda(Pedido p, String data, int idEmpregado, int formaPagamento){
		App.banco.gravarPedido(p);
		for(int i=0;i<p.getQuantDeProd().size();i++){
			App.banco.gravarContemEmPedido(p.getProdNoCarrinho().get(i).getId(), p.getId(), p.getQuantDeProd().get(i));
		}
		this.pedido = p;
		this.data=data;
		this.idEmpregado = idEmpregado;
		this.formaPagamento= formaPagamento;
	}
	
	public Venda(int id ,Pedido p, String data, int idEmpregado, int formaPagamento){
		App.banco.gravarPedido(p);
		for(int i=0;i<p.getQuantDeProd().size();i++){
			App.banco.gravarContemEmPedido(p.getProdNoCarrinho().get(i).getId(), p.getId(), p.getQuantDeProd().get(i));
		}
		this.id = id;
		this.pedido = p;
		this.data=data;
		this.idEmpregado = idEmpregado;
		this.formaPagamento= formaPagamento;
	}

	public int getIdEmpregado() {
		return idEmpregado;
	}

	public void setIdEmpregado(int idEmpregado) {
		this.idEmpregado = idEmpregado;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(int formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	
}
