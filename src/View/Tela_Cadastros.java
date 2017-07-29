package View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import App.App;
import Model.Cliente;


public class Tela_Cadastros extends JFrame implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel prolnome, prolvalidade, prolpreco, prolquant_estoque, proldescricao;
	JTextField profnome, profvalidade, profpreco, profquant_estoque, profdescricao;
	JButton probcadastrar, probsair, problimpar;

	JLabel clilnome, cliltipo, cliltelefone;
	JTextField clifnome, cliftelefone;
	JButton clibcadastrar, clibsair, cliblimpar;
	JComboBox clicombo;

	JLabel selnome, seldescricao;
	JTextField sefnome, sefdescricao;
	JButton sebcadastrar, sebsair, seblimpar;
	
	JLabel fulnome, fulsexo, fulmatricula, fullogin, fulsenha, fulresenha;
	JTextField fufnome, fufmatricula, fuflogin, fufsenha, fufresenha;
	JButton fubcadastrar, fubsair, fublimpar;
	
	public Tela_Cadastros(){
		super( "Tela de Cadastros" );
		JTabbedPane tabbedPane = new JTabbedPane(); 

		// TELA PRODUTOS 
		prolnome = new JLabel("NOME:");
		profnome = new JTextField(25);
		prolvalidade = new JLabel("VALIDADE:");
		profvalidade = new JTextField(25);
		prolpreco = new JLabel("PREÇO:");
		profpreco = new JTextField(25);
		prolquant_estoque = new JLabel("QUANTIDADE EM ESTOQUE:");
		profquant_estoque = new JTextField(25);
		proldescricao= new JLabel("DESCRIÇÃO:");
		profdescricao = new JTextField(25);
		probcadastrar = new JButton("CADASTRAR");
		probcadastrar.addActionListener(this);
		probsair = new JButton("SAIR");
		probsair.addActionListener(this);
		problimpar = new JButton("LIMPAR");
		problimpar.addActionListener(this);


		JLabel label1 = new JLabel( "", SwingConstants.CENTER );
		JPanel panel1 = new JPanel(); 

		panel1.add(prolnome);
		panel1.add(profnome);
		panel1.add(prolvalidade);
		panel1.add(profvalidade);
		panel1.add(prolpreco);
		panel1.add(profpreco);
		panel1.add(prolquant_estoque);
		panel1.add(profquant_estoque);
		panel1.add(proldescricao);
		panel1.add(profdescricao);
		panel1.add(probcadastrar);
		panel1.add(probsair);
		panel1.add(problimpar);

		panel1.add( label1 );
		tabbedPane.addTab( "PRODUTO", null, panel1, "First Panel" ); 




		// TELA CLIENTE

		clicombo = new JComboBox(new Object[]{"              PESSOA FÍSICA           ", "          PESSOA JURÍDICA        "});
		clilnome = new JLabel("               NOME:               ");
		clifnome = new JTextField(25);
		cliltipo = new JLabel("                    TIPO:                    ");
		cliltelefone = new JLabel("TELEFONE:");
		cliftelefone = new JTextField(25);
		clibcadastrar = new JButton("CADASTRAR");
		clibcadastrar.addActionListener(this);
		clibsair = new JButton("SAIR");
		clibsair.addActionListener(this);
		cliblimpar = new JButton("LIMPAR");
		cliblimpar.addActionListener(this);

		JLabel label2 = new JLabel( "", SwingConstants.CENTER );
		JPanel panel2 = new JPanel(); 

		panel2.add(cliltipo);
		panel2.add(clicombo);
		panel2.add(clilnome);
		panel2.add(clifnome);
		panel2.add(cliltelefone);
		panel2.add(cliftelefone);
		panel2.add(clibcadastrar);
		panel2.add(clibsair);
		panel2.add(cliblimpar);

		panel2.add( label2 ); 
		tabbedPane.addTab( "CLIENTE", null, panel2, "Second Panel" );




		// TELA SESSÃO

		selnome = new JLabel("NOME:");
		sefnome = new JTextField(25);
		seldescricao = new JLabel("DESCRIÇÃO:");
		sefdescricao = new JTextField(25);
		sebcadastrar = new JButton("CADASTRAR");
		sebcadastrar.addActionListener(this);
		sebsair = new JButton("SAIR");
		sebsair.addActionListener(this);
		seblimpar = new JButton("LIMPAR");
		seblimpar.addActionListener(this);

		JLabel label3 = new JLabel( "", SwingConstants.CENTER );
		JPanel panel3 = new JPanel(); 

		panel3.add(selnome);
		panel3.add(sefnome);
		panel3.add(seldescricao);
		panel3.add(sefdescricao);
		panel3.add(sebcadastrar);
		panel3.add(sebsair);
		panel3.add(seblimpar);

		tabbedPane.addTab( "SESSÃO", null, panel3, "Third Panel" );



		//TELA FUNCIONÁRIO

		JComboBox fucombo = new JComboBox(new Object[]{"               MASCULINO               ", "               FEMININO               "});

		fulsexo = new JLabel("               SEXO:               ");
		fulnome = new JLabel("               NOME:               ");
		fufnome = new JTextField(25);
		fulmatricula = new JLabel("MATRÍCULA:");
		fufmatricula = new JTextField(25);
		fullogin = new JLabel("LOGIN:");
		fuflogin = new JTextField(25);
		fulsenha = new JLabel("SENHA:");
		fufsenha = new JTextField(25);
		fulresenha = new JLabel("CONFIRMAR A SENHA:");
		fufresenha = new JTextField(25);
		fubcadastrar = new JButton("CADASTRAR");
		fubcadastrar.addActionListener(this);
		fubsair = new JButton("SAIR");
		fubsair.addActionListener(this);
		fublimpar = new JButton("LIMPAR");
		fublimpar.addActionListener(this);

		JLabel label4 = new JLabel( "", SwingConstants.CENTER );
		JPanel panel4 = new JPanel(); 

		panel4.add(fulsexo);
		panel4.add(fucombo);
		panel4.add(fulnome);
		panel4.add(fufnome);
		panel4.add(fulmatricula);
		panel4.add(fufmatricula);
		panel4.add(fullogin);
		panel4.add(fuflogin);
		panel4.add(fulsenha);
		panel4.add(fufsenha);
		panel4.add(fulresenha);
		panel4.add(fufresenha);
		panel4.add(fubcadastrar);
		panel4.add(fubsair);
		panel4.add(fublimpar);

		panel4.add( label4 );
		tabbedPane.addTab( "FUNCIONÁRIO", null, panel4, "Second Panel" );

		add( tabbedPane );
		
	}

		
	public void actionPerformed(ActionEvent e) {
		// AÇÃO PRODUTO
		if(e.getSource().equals(this.probcadastrar)) {
			
			dispose();
		}
		if (e.getSource().equals(this.probsair)) {
			dispose();
			new Tela_Menu();
		}
		if (e.getSource().equals(this.problimpar)) {
			dispose();
			// COMANDO LIMPAR JTEXTFIELD
		}
		
		//AÇÃO CLIENTE
		if(e.getSource().equals(this.clibcadastrar)) {
	//		Cliente c = new Cliente(nome, tipo, telefone);
	//		APP.BD.cadastrarCliente(c);
			
			if(clicombo.getSelectedItem().equals("Pessoa Fisica")){
				
			}
			
			dispose();
		}
		if (e.getSource().equals(this.clibsair)) {
			dispose();
			new Tela_Menu();
		}
		if (e.getSource().equals(this.cliblimpar)) {
			dispose();
			// COMANDO LIMPAR JTEXTFIELD
		}
		
		//AÇÃO SESSÃO
		if(e.getSource().equals(this.sebcadastrar)) {
			//METODO CADASTRAR
			dispose();
		}
		if (e.getSource().equals(this.sebsair)) {
			dispose();
			new Tela_Menu();
		}
		if (e.getSource().equals(this.seblimpar)) {
			dispose();
			// COMANDO LIMPAR JTEXTFIELD
		}
		
		//AÇÃO FUNCIONÁRIO
		if(e.getSource().equals(this.fubcadastrar)) {
			//METODO CADASTRAR
			dispose();
		}
		if (e.getSource().equals(this.fubsair)) {
			dispose();
			new Tela_Menu();
		}
		if (e.getSource().equals(this.fublimpar)) {
			dispose();
			// COMANDO LIMPAR JTEXTFIELD
		}
	}

} 

