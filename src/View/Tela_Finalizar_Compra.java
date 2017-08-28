package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Tela_Finalizar_Compra extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
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
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(43, 293, 108, 31);
		getContentPane().add(btnSalvar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(159, 293, 108, 31);
		getContentPane().add(btnVoltar);
		setVisible(true);
	
		
	}
	public static void main(String[] args) {
		new Tela_Finalizar_Compra();
	}
}
