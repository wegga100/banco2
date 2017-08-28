package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ObjectInputStream.GetField;

import javax.swing.JOptionPane;

import Model.Pedido;
import Model.Venda;
import View.Tela_Finalizar_Compra;
import View.Tela_Venda;

public class ControleVenda {

	private Pedido pedido;
	private Venda venda;
	
	
	public ControleVenda(Tela_Finalizar_Compra compra){
		
		pedido =  new Pedido();
	
	}
	
	
	
}
