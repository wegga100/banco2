package App;

import java.util.ArrayList;
import Controle.BancoDados;
import Controle.Conect;
import Controle.ControleLogin;
import Controle.ControleTelaFinalVenda;
import Model.Cliente;
import Model.Empregado;
import Model.Produtos;
import Model.Seccao;
import View.TelaErro;
import View.TelaLogin;
import View.Tela_Finalizar_Compra;
import View.Tela_Menu;
import View.Tela_Pesquisa;


public class App {
	
	public static BancoDados banco = new BancoDados();
	public static Conect conectar =  new Conect();
	public static TelaErro erro =  new TelaErro();
	public static Empregado  empregado;

	public static void main(String[] args) {
		
				
		banco.conectar();
		 if(banco.estaConectado()){
			 System.out.println("sim");
		 }
		 else{
			 System.out.println("nao");
			 
		 }
		 //ControleLogin l =  new ControleLogin(new TelaLogin());
		 new Tela_Menu();
	
	}

}
