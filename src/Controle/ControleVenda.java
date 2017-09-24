package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import App.App;
import Model.Pedido;
import Model.Produtos;
import Model.Venda;
import View.Tela_Finalizar_Compra;
import View.Tela_Venda;

public class ControleVenda {

	private Pedido pedido;
	private Venda venda;
	private int codBarras, x;
	private Produtos prodConsulta;
	private float valorProds;
	
	
	public ControleVenda(Tela_Venda venda){
		
		pedido =  new Pedido();
		pedido.setIdCliente(1);
		venda.getFpreco().setEditable(false);
		
		venda.getFproduto().addKeyListener( new KeyListener() {
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) {}
			public void keyPressed(KeyEvent e) {
				
				if(venda.getFproduto().getText().equals("")){
					App.erro.mensagemErro("Inserir codigo de barras do produto");
				}
				else if(e.getKeyCode()==KeyEvent.VK_ENTER){
					
					codBarras = Integer.parseInt(venda.getFproduto().getText());
					prodConsulta = App.banco.pesquisarProdCodigo(codBarras);
					venda.getFpreco().setEditable(true);
					venda.getFpreco().setText(""+prodConsulta.getPreco());
					venda.getFpreco().setEditable(false);
					
				}
			}
		});
		
		venda.getFquantidade().addKeyListener( new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				if(venda.getFquantidade().getText().equals("")){
					App.erro.mensagemErro("Inserir quantidade");
				}
				else if(e.getKeyCode()==KeyEvent.VK_ENTER){
					
					x  = Integer.parseInt(venda.getFquantidade().getText());
					valorProds = x* prodConsulta.getPreco();
					venda.getFtotal().setText("R$ "+valorProds);
					venda.getFtotal().setEditable(false);
					
				}
			}
		});
		
		venda.getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((venda.getFquantidade().getText().equals(""))||(venda.getFproduto().getText().equals(""))){
					App.erro.mensagemErro("Preemcher campos obrigatorios");
				}
				pedido.addItem(prodConsulta, x);
				venda.getFtotalgeral().setText("R$ "+pedido.getValorTotal());
				
				venda.getFtotal().setEditable(true);
				venda.getFtotal().setText("");
				venda.getFpreco().setEditable(true);
				venda.getFpreco().setText("");
				venda.getFquantidade().setText("");
				venda.getFproduto().setText("");
			}
		});
		
		venda.getVebsalvar().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ControleTelaFinalVenda(pedido, new Tela_Finalizar_Compra(), venda);
			}
		});
		
		
	}
	
	public void tabelaPreencher(Pedido p, Tela_Venda venda){

		venda.getModelo().setNumRows(0);
		ArrayList<Produtos> prod = App.banco.pesquisarProd();
		
		for(int i=0;i<p.getProdNoCarrinho().size();i++){
			venda.getModelo().addRow(new Object[]{p.getNome(),p.getQuantEstoque(),p.getPreco()});
		}		
	}
	
}
