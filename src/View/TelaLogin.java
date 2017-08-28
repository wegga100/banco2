package View;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaLogin extends JFrame {
	
	
	public JButton loginButton, sairButton;
	public JTextField fieldaLogin, fieldSenha;
	public JLabel loginLabel, senhaLabel;

	public TelaLogin(){
		setTitle("Login");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new FlowLayout());
		setSize(200, 130);
		
		loginLabel =  new JLabel("Login :");
		add(loginLabel);
		fieldaLogin= new JTextField(10);
		add(fieldaLogin);
		senhaLabel =  new JLabel("Senha :");
		add(senhaLabel);
		fieldSenha =  new JTextField(10);
		add(fieldSenha);
		
		loginButton =  new JButton("logar");
		add(loginButton);
		sairButton =  new JButton("Sair");
		add(sairButton);
		
		setVisible(true);
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	public JButton getSairButton() {
		return sairButton;
	}

	public void setSairButton(JButton sairButton) {
		this.sairButton = sairButton;
	}

	public JTextField getFieldaLogin() {
		return fieldaLogin;
	}

	public void setFieldaLogin(JTextField fieldaLogin) {
		this.fieldaLogin = fieldaLogin;
	}

	public JTextField getFieldSenha() {
		return fieldSenha;
	}

	public void setFieldSenha(JTextField fieldSenha) {
		this.fieldSenha = fieldSenha;
	}
	
}
