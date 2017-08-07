package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Tela_Pesquisa extends JFrame implements ActionListener{
	
	
	JTextField fielpesquisa, fielrelatorio;
	JButton buscar, voltar, Alterar;
	JComboBox pescombo;

	public Tela_Pesquisa() {
		
		JComboBox pescombo = new JComboBox(new Object[]{"PESQUISAR POR", "PRODUTOS", "CLINTE","SECÇÃO", "FUNCIONÁRIOS"});

		fielpesquisa = new JTextField(10);
		buscar = new JButton("BUSCAR");
		buscar.addActionListener(this);
		fielrelatorio = new JTextField(10);
		voltar = new JButton("VOLTAR");
		voltar.addActionListener(this);
		Alterar = new JButton("ALTERAR");
		Alterar.addActionListener(this);
		
		
		add(fielpesquisa);
		add(pescombo);
		add(buscar);
		add(fielrelatorio);
		add(voltar);
		add(Alterar);
		
		pescombo.setBounds(545, 20, 200, 40);
		fielpesquisa.setBounds(20, 20, 520, 40);
		buscar.setBounds(750, 20, 120, 40);
		fielrelatorio.setBounds(20, 80, 850, 300);
		voltar.setBounds(750, 400, 120, 40);
		Alterar.setBounds(625, 400, 120, 40);
		
		setTitle("TELA DE PESQUISA");
		setLayout(null);
		setSize(896,503);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource().equals(this.buscar)) {
		
			
	}
	if(e.getSource().equals(this.Alterar)) {
		
	}
	if(e.getSource().equals(this.voltar)) {
		dispose();
		new Tela_Menu();
	}	
	}
	
	public static void main(String[] args) {
		new Tela_Pesquisa();
	}

}
