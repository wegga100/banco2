package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ObjectInputStream.GetField;

import javax.swing.JOptionPane;

import View.Tela_Finalizar_Compra;
import View.Tela_Venda;

public class ControleVenda {

	private boolean validador = false;
	public ControleVenda(){

	}
	
	public boolean finalizarVenda(float valor, Tela_Finalizar_Compra compra){
		
		compra.getTextField().setText("R$ "+valor);
		compra.getTextField().setEditable(false);
		
		compra.getTextField_1().addKeyListener( new KeyListener() {
			
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					float x =  Float.parseFloat(compra.getTextField_1().getText());
					float r = valor-x;
					if(r<0){
						JOptionPane.showMessageDialog(null, "Valor informado é inferior ao da compra ");
						compra.getTextField_1().setText("");
					}else {
						compra.getTextField_2().setText("R$ "+r);
					}	
				}
				
			}
		});
		
		compra.getBtnSalvar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				validador = true;
			}
		});
		
		compra.getBtnVoltar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				validador  =  false;
				
			}
		});
		
		
		return false;
	}
	
}
