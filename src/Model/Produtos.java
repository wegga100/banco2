package Model;

import java.sql.Date;

public class Produtos {
	
	private int id ;
	private String nome;
	private String codBarras;
	private String dataValidade;
	private float preco;
	private int quantEstoque;
	private String descricao;
	private int idSeccao;
	
	public Produtos( String nome, String codBarras,String dataValidade, float preco, int quantEstoque, String descricao, int idSeccao) {
		this.nome = nome;
		this.codBarras = codBarras;
		this.dataValidade= dataValidade;
		this.preco = preco;
		this.quantEstoque=quantEstoque;
		this.descricao=descricao;
		this.idSeccao=idSeccao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantEstoque() {
		return quantEstoque;
	}

	public void setQuantEstoque(int quantEstoque) {
		this.quantEstoque = quantEstoque;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdSeccao() {
		return idSeccao;
	}

	public void setIdSeccao(int idSeccao) {
		this.idSeccao = idSeccao;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public int getId() {
		return id;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public String getDataValidade() {
		return dataValidade;
	}
	
	

}
