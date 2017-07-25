package Model;

public class Empregado extends Cliente {
	private String matricula;
	private String senha;
	
	public Empregado(String nome, int tipo, String telefone, String matricula, String senha) {
		super( nome, tipo, telefone);
		this.matricula=matricula;
		this.senha=senha;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
