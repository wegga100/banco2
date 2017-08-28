package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Model.Venda;

import javax.swing.JButton;

public class Tela_Finalizar_Compra extends JFrame{
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnSalvar, btnVoltar ;
	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public Tela_Finalizar_Compra() {
		
		setSize(300,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblValorAPagar = new JLabel("VALOR A PAGAR");
		lblValorAPagar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblValorAPagar.setBounds(43, 51, 108, 14);
		getContentPane().add(lblValorAPagar);
		
		textField = new JTextField();
		textField.setBounds(43, 69, 201, 34);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(43, 142, 201, 34);
		getContentPane().add(textField_1);
		
		JLabel lblValorPago = new JLabel("VALOR PAGO");
		lblValorPago.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblValorPago.setBounds(43, 124, 108, 14);
		getContentPane().add(lblValorPago);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(43, 225, 201, 34);
		getContentPane().add(textField_2);
		
		JLabel lblTroco = new JLabel("TROCO");
		lblTroco.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblTroco.setBounds(43, 207, 108, 14);
		getContentPane().add(lblTroco);
		
		btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(43, 293, 108, 31);
		getContentPane().add(btnSalvar);
		
		btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(159, 293, 108, 31);
		getContentPane().add(btnVoltar);
		setVisible(true);
	
		
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}
	
	
	
}
