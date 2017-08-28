package Model;

import java.util.ArrayList;

public class Pedido {

	private int id;
	private float valorTotal;
	private int idCliente;
	private ArrayList<Produtos> prodNoCarrinho= new ArrayList<>();
	private ArrayList<Integer> quantDeProd =new ArrayList<>();

	public Pedido(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	public Pedido(){
		
	}
	
	public Pedido(int id , float valorTotal, int idCliente) {
		this.id = id;
		this.valorTotal = valorTotal;
		this.idCliente = idCliente;
	}

	public void addItem(Produtos prod, int quant){
		prodNoCarrinho.add(prod);
		quantDeProd.add(quant);
		valorTotal+=prod.getPreco()*quant;
	}
	
	public void removerItem(int posicao){
		valorTotal-=prodNoCarrinho.get(posicao).getPreco()*quantDeProd.get(posicao);
		prodNoCarrinho.remove(posicao);
		quantDeProd.remove(posicao);
	
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public ArrayList<Produtos> getProdNoCarrinho() {
		return prodNoCarrinho;
	}

	public void setProdNoCarrinho(ArrayList<Produtos> prodNoCarrinho) {
		this.prodNoCarrinho = prodNoCarrinho;
	}

	public ArrayList<Integer> getQuantDeProd() {
		return quantDeProd;
	}

	public void setQuantDeProd(ArrayList<Integer> quantDeProd) {
		this.quantDeProd = quantDeProd;
	}

	public String[] getLinhaTable(){
		return new String[]{String.valueOf(this.nome), };
	}
	
	
}
