package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;

public class Tela_Venda extends JFrame implements ActionListener {
	
	JButton vebsalvar, vebcancelar;
	JLabel produto, quantidade, preco, total, totalgeral;
	JTextField fproduto, fquantidade, fpreco, ftotal, ftotalgeral;
	private JTable table;
	private JTable table_1;
	
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
		vebsalvar.addActionListener(this);
		vebcancelar = new JButton("CANCELAR");
		vebcancelar.addActionListener(this);
						
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
		fproduto.setBounds(20, 60, 700, 35);
		quantidade.setBounds(725, 35, 150, 30);
		fquantidade.setBounds(725, 60, 100, 35);
		preco.setBounds(830, 35, 150, 30);
		fpreco.setBounds(830, 60, 120, 35);
		total.setBounds(955, 35, 150, 30);
		ftotal.setBounds(955, 60, 120, 35);
		vebsalvar.setBounds(20, 10, 150, 30);
		vebcancelar.setBounds(180, 10, 150, 30);
		totalgeral.setBounds(870, 550, 150, 30);
		ftotalgeral.setBounds(925, 540, 150, 50);
		
		setTitle("TELA DE VENDA");
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(605, 239, 1, 1);
		getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBounds(20, 106, 1055, 429);
		getContentPane().add(table_1);
		setSize(1100, 650);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private void Mai() {
		new Tela_Venda();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
