package App;

import java.util.ArrayList;

import Controle.BancoDados;
import Model.Cliente;
import Model.Produtos;
import View.TelaErro;

public class App {
	
	public static BancoDados banco = new BancoDados();
	public static TelaErro erro =  new TelaErro();

	public static void main(String[] args) {
		
		App.banco.conectar();
		 if(App.banco.estaConectado()){
			 System.out.println("sim");
		 }
		 else{
			 System.out.println("nao");
		 }
		 
		 

	}

}
