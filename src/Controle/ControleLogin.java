package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import App.App;
import View.TelaLogin;
import View.Tela_Menu;

public class ControleLogin {
	
	public ControleLogin(TelaLogin tela){
		
		tela.getLoginButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (App.banco.validarLogin(tela.getFieldaLogin().getText(),tela.getFieldSenha().getText())){
					new Tela_Menu();
					tela.dispose();
					System.gc();
				}else {
					tela.getFieldaLogin().setText("");
					tela.getFieldSenha().setText("");
					App.erro.mensagemErro("Login ou senha invalido");
				}
			
			}
		});
		tela.sairButton.addActionListener(new ActionListener(
				) {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		
		
	}
}
