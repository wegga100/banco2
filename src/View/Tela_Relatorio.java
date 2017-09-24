package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.sun.javafx.font.Disposer;

import App.App;
import Model.Produtos;

public class Tela_Relatorio extends JFrame {

	
private DefaultTableModel modelo = new DefaultTableModel();
private JTable tabela;
private JButton voltarB;
	
	
	public Tela_Relatorio(){
		criarTabela();
		criaJanela();
		setVisible(true);
	}
	
	
	public void criarTabela(){
		tabela = new JTable(modelo);
		modelo.addColumn("Nome");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Preço");
		
		tabela.getColumnModel().getColumn(0).setPreferredWidth(25);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(3);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(7);
	
	
		modelo.setNumRows(0);
		 ArrayList<Produtos> prod = App.banco.pesquisarProd();
		 
		 for (Produtos p : prod){
			  	modelo.addRow(new Object[]{p.getNome(),p.getQuantEstoque(),p.getPreco()});
		 }
	
	}
	
	public void criaJanela() {
		
		JPanel painelBotoes = new JPanel();
		voltarB =  new JButton("Voltar");
		painelBotoes.add(voltarB);
		
		voltarB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Tela_Menu();
			}
		});
		JScrollPane barraRolagem = new JScrollPane(tabela);
		JPanel painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);

	
		painelFundo.add(BorderLayout.SOUTH, painelBotoes);
		

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
}