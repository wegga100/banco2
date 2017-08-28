package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import App.App;
import Model.Cliente;
import Model.Empregado;
import Model.Produtos;
import Model.Seccao;

import javax.swing.table.DefaultTableModel;

public class Tela_Pesquisa extends JFrame implements ActionListener{


	JTextField fielpesquisa, fielrelatorio;
	JButton buscar, voltar, Alterar;
	JComboBox pescombo;

	JScrollPane scrollPane ;
	JTable teble;



	public Tela_Pesquisa() {

		TableModel dm = null;

		pescombo = new JComboBox();
		pescombo.addItem("SELECIONE");
		pescombo.addItem("PRODUTOS");
		pescombo.addItem("CLIENTE");
		pescombo.addItem("SECÇÃO");
		pescombo.addItem("FUNCIONÁRIOS");
		pescombo.setSelectedIndex(0);

		fielpesquisa = new JTextField(10);
		buscar = new JButton("BUSCAR");
		buscar.addActionListener(this);
		fielrelatorio = new JTextField(10);
		voltar = new JButton("VOLTAR");
		voltar.addActionListener(this);
		Alterar = new JButton("ALTERAR");
		Alterar.addActionListener(this);


		getContentPane().add(fielpesquisa);
		getContentPane().add(pescombo);
		getContentPane().add(buscar);
		getContentPane().add(fielrelatorio);
		getContentPane().add(voltar);
		getContentPane().add(Alterar);

		pescombo.setBounds(545, 20, 200, 40);
		fielpesquisa.setBounds(20, 20, 520, 40);
		buscar.setBounds(750, 20, 120, 40);
		//fielrelatorio.setBounds(20, 80, 850, 300);
		voltar.setBounds(750, 400, 120, 40);
		Alterar.setBounds(625, 400, 120, 40);

		setTitle("TELA DE PESQUISA");
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 100, 850, 289);
		getContentPane().add(scrollPane);
		//dm.addColumn("ID");
		//teble.getColumnModel().getColumn(0).setPreferredWidth(10);

		setSize(896,503);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.buscar)) {

			if(pescombo.getSelectedItem().equals("SELECIONE")){
				System.out.println("oi");
				JOptionPane.showConfirmDialog(null, "ops. já e");
			}
			//			if(pescombo.getSelectedItem().equals(e)){
			//				System.err.println("Estou ak");
			//				JOptionPane.showInternalMessageDialog(null, "Escolha a opçao de Busca");	
			//			}
			if(pescombo.getSelectedItem().equals("PRODUTOS")){

				montarTabelaProdutos();


			}
			if(pescombo.getSelectedItem().equals("CLIENTE")){
				System.out.println("TESTE");
				montarTabelaCliente();
			}
			if(pescombo.getSelectedItem().equals("SECÇÃO")){
				montarTabelaSeccao();

			}
			if(pescombo.getSelectedItem().equals("FUNCIONARIO")){
				montarTabelaFuncionario();
			}



		}
		if(e.getSource().equals(this.Alterar)) {

		}
		if(e.getSource().equals(this.voltar)) {
			dispose();
			new Tela_Menu();
		}	
	}

	public void montarTabelaProdutos(){
		teble = new JTable(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"NOME", " QUANTIDADE ESTOQUE", "PREÇO"
				}
				));
		scrollPane.setViewportView(teble);
		//App.banco.conectar();
		//List<Produtos> produtos = App.banco.pesquisarProd("");

		List<Produtos> produtos = new ArrayList<>();
		Produtos po = new Produtos("ELDON", "asdasd", "asdasd", 12, 1, "asdasd", 1212);
		po.setId(10);

		produtos.add(po);

		po = new Produtos("E121212LDON", "asdasd", "asdasd", 12, 1, "asda121212sd", 1212);
		po.setId(12);

		produtos.add(po);


		DefaultTableModel model = (DefaultTableModel) teble.getModel();
		model.setRowCount(0);
		for(Produtos p: produtos){
			model.addRow(p.getLinhaTable());	
		}

		int lina = teble.getSelectedRow();
		String id = (String) model.getValueAt(lina, 0);


	}

	public void montarTabelaCliente(){
		teble = new JTable(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"NOME", "TIPO", "TELEFONE"
				}
				));
		scrollPane.setViewportView(teble);

		List<Cliente> cliente = new ArrayList<>();
		Cliente cli = new Cliente("Maria", 0, "879999949");
		cli.setId(10);

		cliente.add(cli);


		Cliente cli1 = new Cliente("josé", 1, "879999949");
		cli1.setId(10);

		cliente.add(cli1);


		DefaultTableModel model = (DefaultTableModel) teble.getModel();
		model.setRowCount(0);
		for(Cliente c: cliente){
			model.addRow(c.getLinhaTable());	
		}

		int lina = teble.getSelectedRow();
		String id = (String) model.getValueAt(lina, 0);


	}

	public void montarTabelaSeccao(){
		teble = new JTable(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"NOME", "DESCRIÇÃO"
				}
				));
		scrollPane.setViewportView(teble);

		List<Seccao> seccao = new ArrayList<>();
		Seccao se = new Seccao("Maria", "lajkdslkk askjdkl");
		se.setId(10);

		seccao.add(se);


		Seccao se1 = new Seccao("josé","asld qlwlqkw");
		se1.setId(10);

		seccao.add(se1);


		DefaultTableModel model = (DefaultTableModel) teble.getModel();
		model.setRowCount(0);
		for(Seccao s: seccao){
			model.addRow(s.getLinhaTable());	
		}

		int lina = teble.getSelectedRow();
		String id = (String) model.getValueAt(lina, 0);
	}

	public void montarTabelaFuncionario(){
		teble = new JTable(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"NOME", "MATRICULA"
				}
				));
		scrollPane.setViewportView(teble);

		List<Empregado> empregado = new ArrayList<>();
		Empregado em = new Empregado("José Antonio", 1, "763483", "27346", "das");
		em.setId(10);

		empregado.add(em);


		Empregado em1 = new Empregado("Pedro", 0, "wewde", "dfwe", "wefw");
		em1.setId(10);

		empregado.add(em1);


		DefaultTableModel model = (DefaultTableModel) teble.getModel();
		model.setRowCount(0);
		for(Empregado e: empregado){
			model.addRow(e.getLinhaTable());	
		}

		int lina = teble.getSelectedRow();
		String id = (String) model.getValueAt(lina, 0);
	}
}
