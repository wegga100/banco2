package Model;

public class Cliente {
	private int id;
	private String nome;
	private int tipo;
	private String telefone;

	public Cliente( String nome, int tipo, String telefone) {

		this.nome=nome;
		this.tipo=tipo;
		this.telefone=telefone;
		//
	}
	
	
	public Cliente(int id, String nome, int tipo, String telefone) {

		this.nome=nome;
		this.tipo=tipo;
		this.telefone=telefone;
		this.id = id;
		//
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

}
