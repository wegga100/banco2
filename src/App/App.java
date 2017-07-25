package App;

import Controle.BancoDados;

public class App {
	
	public static BancoDados banco = new BancoDados();

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
