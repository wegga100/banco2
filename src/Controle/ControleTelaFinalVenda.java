package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import App.App;
import Model.Pedido;
import Model.Venda;
import View.Tela_Finalizar_Compra;
import View.Tela_Menu;
import View.Tela_Venda;

public class ControleTelaFinalVenda {
	
	
	
	private boolean validador = false;
	
	public ControleTelaFinalVenda(Pedido f ,Tela_Finalizar_Compra compra,Tela_Venda tela){	
		
		compra.getTextField().setText(""+f.getValorTotal());
		compra.getTextField().setEditable(false);
		
		compra.getTextField_1().addKeyListener( new KeyListener() {
			
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					float x =  f.getValorTotal();
					float r = f.getValorTotal()-x;
					if(r<0){
						JOptionPane.showMessageDialog(null, "Valor informado é inferior ao da compra ");
						compra.getTextField_1().setText("");
					}else {
						compra.getTextField_2().setText(" "+r);
					}	
				}
				
			}
		});
		
		compra.getBtnSalvar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				for(int i =0;i<f.getQuantDeProd().size();i++){
					for(int j=0;j<f.getQuantDeProd().get(i);j++)
						App.banco.retirarDoEstoque(""+f.getProdNoCarrinho().get(i).getCodBarras());
				}
				
				App.banco.gravarPedido(f);
				tela.dispose();
				new Tela_Menu();
				validador = true;
			}
		});
		
		compra.getBtnVoltar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				validador  =  false;
				
			}
		});
		
		
		
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
