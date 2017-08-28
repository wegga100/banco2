package App;

import java.util.ArrayList;
import Controle.BancoDados;
import Controle.Conect;
import Model.Cliente;
import Model.Empregado;
import Model.Produtos;
import Model.Seccao;
import View.TelaErro;
import View.Tela_Menu;
import View.Tela_Pesquisa;


public class App {
	
	public static BancoDados banco = new BancoDados();
	public static Conect conectar =  new Conect();
	public static TelaErro erro =  new TelaErro();

	public static void main(String[] args) {
		
				
		conectar.conectar();
		 if(conectar.estaConectado()){
			 System.out.println("sim");
		 }
		 else{
			 System.out.println("nao");
			 
		 }
		 
		 
		//new Tela_Menu();
	}

}
