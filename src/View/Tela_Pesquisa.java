package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Tela_Pesquisa extends JFrame implements ActionListener{
	
	
	JTextField fielpesquisa, fielrelatorio;
	JButton buscar, voltar;

	public Tela_Pesquisa() {
		
		fielpesquisa = new JTextField(10);
		buscar = new JButton("BUSCAR");
		buscar.addActionListener(this);
		fielrelatorio = new JTextField(10);
		voltar = new JButton("VOLTAR");
		voltar.addActionListener(this);
		
		
		add(fielpesquisa);
		add(buscar);
		add(fielrelatorio);
		add(voltar);
		
		fielpesquisa.setBounds(20, 20, 720, 40);
		buscar.setBounds(750, 20, 120, 40);
		fielrelatorio.setBounds(20, 80, 850, 300);
		voltar.setBounds(750, 400, 120, 40);
		
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
		
			dispose();
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
