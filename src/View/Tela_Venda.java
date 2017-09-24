package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

import App.App;
import Model.Cliente;
import Model.Pedido;
import Model.Produtos;

import javax.swing.table.DefaultTableModel;

import Model.Cliente;
import Model.Pedido;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class Tela_Venda extends JFrame  {
	
	JButton vebsalvar, vebcancelar;
	JLabel produto, quantidade, preco, total, totalgeral;
	JTextField fproduto, fquantidade, fpreco, ftotal, ftotalgeral;
	private JTable table;
	DefaultTableModel modelo =  new DefaultTableModel(); 
	private JButton btnNewButton;
	private JTable table_1;
	JScrollPane scrollPane ;
	public Tela_Venda() {
		
		produto = new JLabel("PRODUTO");
		fproduto = new JTextField(20); 
		quantidade = new JLabel("QUANTIDADE");
		fquantidade = new JTextField(20);
		preco = new JLabel("PRECO");
		fpreco = new JTextField(20);
		total = new JLabel("TOTAL");
		ftotal = new JTextField(20);
		totalgeral = new JLabel("TOTAL");
		ftotalgeral = new JTextField(20);
		vebsalvar = new JButton("FINALIZAR");
		vebcancelar = new JButton("CANCELAR");
						
		getContentPane().add(produto);
		getContentPane().add(fproduto);
		getContentPane().add(quantidade);
		getContentPane().add(fquantidade);
		getContentPane().add(preco);
		getContentPane().add(fpreco);
		getContentPane().add(total);
		getContentPane().add(ftotal);
		getContentPane().add(vebsalvar);
		getContentPane().add(vebcancelar);
		getContentPane().add(ftotalgeral);
		getContentPane().add(totalgeral);
		
		produto.setBounds(20, 35, 150, 30);
		fproduto.setBounds(20, 60, 586, 35);
		quantidade.setBounds(616, 35, 150, 30);
		fquantidade.setBounds(616, 60, 100, 35);
		preco.setBounds(721, 35, 150, 30);
		fpreco.setBounds(721, 60, 120, 35);
		total.setBounds(846, 35, 150, 30);
		ftotal.setBounds(846, 60, 120, 35);
		vebsalvar.setBounds(20, 10, 150, 30);
		vebcancelar.setBounds(180, 10, 150, 30);
		totalgeral.setBounds(870, 550, 150, 30);
		ftotalgeral.setBounds(925, 540, 150, 50);
		
		setTitle("TELA DE VENDA");
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(605, 239, 1, 1);
		getContentPane().add(table);
		
		btnNewButton = new JButton("ADICIONAR");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Vaniedson\\Desktop\\Sem t\u00EDtulo-1.png"));
		btnNewButton.setBounds(971, 59, 104, 36);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(20, 106, 1055, 423);
		getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setColumnHeaderView(table_1);
		setSize(1100, 650);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public JButton getVebsalvar() {
		return vebsalvar;
	}
	public void setVebsalvar(JButton vebsalvar) {
		this.vebsalvar = vebsalvar;
	}
	public JButton getVebcancelar() {
		return vebcancelar;
	}
	public void setVebcancelar(JButton vebcancelar) {
		this.vebcancelar = vebcancelar;
	}
	public JLabel getProduto() {
		return produto;
	}
	public void setProduto(JLabel produto) {
		this.produto = produto;
	}
	public JLabel getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(JLabel quantidade) {
		this.quantidade = quantidade;
	}
	public JLabel getPreco() {
		return preco;
	}
	public void setPreco(JLabel preco) {
		this.preco = preco;
	}
	public JLabel getTotal() {
		return total;
	}
	public void setTotal(JLabel total) {
		this.total = total;
	}
	public JLabel getTotalgeral() {
		return totalgeral;
	}
	public void setTotalgeral(JLabel totalgeral) {
		this.totalgeral = totalgeral;
	}
	public JTextField getFproduto() {
		return fproduto;
	}
	public void setFproduto(JTextField fproduto) {
		this.fproduto = fproduto;
	}
	public JTextField getFquantidade() {
		return fquantidade;
	}
	public void setFquantidade(JTextField fquantidade) {
		this.fquantidade = fquantidade;
	}
	public JTextField getFpreco() {
		return fpreco;
	}
	public void setFpreco(JTextField fpreco) {
		this.fpreco = fpreco;
	}
	public JTextField getFtotal() {
		return ftotal;
	}
	public void setFtotal(JTextField ftotal) {
		this.ftotal = ftotal;
	}
	public JTextField getFtotalgeral() {
		return ftotalgeral;
	}
	public void setFtotalgeral(JTextField ftotalgeral) {
		this.ftotalgeral = ftotalgeral;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}
	public JTable getTable_1() {
		return table_1;
	}
	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	public DefaultTableModel getModelo() {
		return modelo;
	}
	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	
	public void criarTabela(){
		table = new JTable(modelo);
		modelo.addColumn("nome");
		modelo.addColumn("Codigo Barras");
		modelo.addColumn("quantidade");
		modelo.addColumn("valor");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(8);
		table.getColumnModel().getColumn(2).setPreferredWidth(7);
	
	
	}
	
	
}
