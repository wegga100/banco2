package View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import App.App;
import Model.Cliente;
import Model.Empregado;
import Model.Produtos;
import Model.Seccao;



public class Tela_Cadastros extends JFrame implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String Numero = null;
	JLabel prolnome, prolvalidade, prolpreco, prolquant_estoque, proldescricao, prolcodigo_barras, prolsessao;
	JTextField profnome, profvalidade, profpreco, profquant_estoque, profdescricao, profcodigo_barras, profpesquisa;
	JButton probcadastrar, probsair, problimpar, probpesquisar;

	JLabel clilnome, cliltipo, cliltelefone;
	JTextField clifnome, cliftelefone;
	JButton clibcadastrar, clibsair, cliblimpar;
	JComboBox clicombo;

	JLabel selnome, seldescricao;
	JTextField sefnome, sefdescricao;
	JButton sebcadastrar, sebsair, seblimpar;
	
	JLabel fulnome, fulsexo, fulmatricula, fullogin, fulsenha, fulresenha, fultelefone;
	JTextField fufnome, fufmatricula, fuflogin, fuftelefone;
	JPasswordField fufsenha, fufresenha;
	JButton fubcadastrar, fubsair, fublimpar;
	
	
	
	public Tela_Cadastros(){
		
		
		
		
		super( "Tela de Cadastros" );
		JTabbedPane tabbedPane = new JTabbedPane(); 

		// TELA PRODUTOS 
		prolsessao = new JLabel("                    SESSÃO                    ");
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
		prolcodigo_barras = new JLabel("CODIGO DE BARRAS");
		profcodigo_barras = new JTextField(25);
		profpesquisa = new JTextField(15);
		probpesquisar = new JButton("PESQUISAR");
		probpesquisar.addActionListener(this);
		probcadastrar = new JButton("CADASTRAR");
		probcadastrar.addActionListener(this);
		probsair = new JButton("SAIR");
		probsair.addActionListener(this);
		problimpar = new JButton("LIMPAR");
		problimpar.addActionListener(this);
		fultelefone = new JLabel("TELEFONE");
		fuftelefone = new JTextField(25);
			
		
		try {
			MaskFormatter maskcpf =  new javax.swing.text.MaskFormatter("####");
			profpreco = new JFormattedTextField(maskcpf);
			profpreco.setColumns(24);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			MaskFormatter maskcpf =  new javax.swing.text.MaskFormatter("##/##/####");
			profvalidade = new JFormattedTextField(maskcpf);
			profvalidade.setColumns(24);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			
		profnome.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
			
				char c = e.getKeyChar();
				if(Character.isDigit(c)){
					e.consume();
				}
			}
			
			public void keyReleased(KeyEvent e) {}
			
			public void keyPressed(KeyEvent e) {}
		});
		profquant_estoque.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'0' || c> '9'){
					
					e.consume();
					
				}
				
			}
			
			public void keyReleased(KeyEvent e) {}
			
			public void keyPressed(KeyEvent e) {}
		});


		JLabel label1 = new JLabel( "", SwingConstants.CENTER );
		JPanel panel1 = new JPanel(); 
		
		panel1.add(prolsessao);
		panel1.add(profpesquisa);
		panel1.add(probpesquisar);
		panel1.add(prolcodigo_barras);
		panel1.add(profcodigo_barras);
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
		
		try {
			MaskFormatter maskcpf =  new javax.swing.text.MaskFormatter("##-####-####");
			cliftelefone = new JFormattedTextField(maskcpf);
			cliftelefone.setColumns(24);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
		fufsenha = new JPasswordField(25);
		fulresenha = new JLabel("CONFIRMAR A SENHA:");
		fufresenha = new JPasswordField(25);
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
		panel4.add(fultelefone);
		panel4.add(fuftelefone);
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
			
			
			int i = Integer.parseInt(profquant_estoque.getText());
			float f = Float.parseFloat(profpreco.getText());
			int s = Integer.parseInt(profpesquisa.getText());
			//Produtos w = new Produtos(nome, codBarras, dataValidade, preco, quantEstoque, descricao, idSeccao)	
			Produtos p = new Produtos(profnome.getText(), profcodigo_barras.getText(), profvalidade.getText(), f, i, profdescricao.getText(), s );
			System.out.println(profnome.getText()+ profcodigo_barras.getText() + profvalidade.getText()+ profpreco.getText() + profquant_estoque.getText()+ profdescricao.getText()+ 10);
			// Estudar...
			App.banco.gravarProdutos(p);
			
			
			
			
		}
		if (e.getSource().equals(this.probsair)) {
			dispose();
			new Tela_Menu();
		}
		if (e.getSource().equals(this.problimpar)) {
			
			profpesquisa.getText();
			profcodigo_barras.setText("");
			profnome.setText("");
			profvalidade.setText("");
			profpreco.setText("");
			profquant_estoque.setText("");
			profdescricao.setText("");
			
			
		}
		
		//AÇÃO CLIENTE
		if(e.getSource().equals(this.clibcadastrar)) {
			
			
			
			if(clicombo.getSelectedItem().equals("Pessoa Fisica")){
			  Cliente c = new Cliente(clifnome.getText(), '0' , cliftelefone.getText());
			  App.banco.gravarCliente(c);
			}
			if(clicombo.getSelectedItem().equals("Pessoa Juridica")){
				Cliente c = new Cliente(clifnome.getText(), '1' , cliftelefone.getText());
				App.banco.gravarCliente(c);
			}
			
			clifnome.setText("");
			cliftelefone.setText("");
		}
		if (e.getSource().equals(this.clibsair)) {
			dispose();
			new Tela_Menu();
		}
		if (e.getSource().equals(this.cliblimpar)) {
			
			clifnome.setText("");
			cliftelefone.setText("");
		}
		
		//AÇÃO SESSÃO
		if(e.getSource().equals(this.sebcadastrar)) {
			
			Seccao s = new Seccao(sefnome.getText(), sefdescricao.getText());
			App.banco.gravarSeccao(s);
			System.out.println(sefnome.getText()+sefdescricao.getText());
			
			sefnome.setText("");
			sefdescricao.setText("");
			
		}
		if (e.getSource().equals(this.sebsair)) {
			dispose();
			new Tela_Menu();
		}
		if (e.getSource().equals(this.seblimpar)) {
			sefnome.setText("");
			sefdescricao.setText("");
		}
		
		//AÇÃO FUNCIONÁRIO
		if(e.getSource().equals(this.fubcadastrar)) {
			if(clicombo.getSelectedItem().equals("Masculino")){
				Empregado EM = new Empregado(fufnome.getText(), 0 , fuftelefone.getText(), fufmatricula.getText(), fufsenha.getSelectedText());
				App.banco.gravarEmpregado(EM);
			}
			if(clicombo.getSelectedItem().equals("Feminino")){
				Empregado EM = new Empregado(fufnome.getText(), 1 , fuftelefone.getText(), fufmatricula.getText(), fufsenha.getSelectedText());
				App.banco.gravarEmpregado(EM);
			}
			
			fufnome.setText("");
			fuftelefone.setText("");
			fufmatricula.setText("");
			fuflogin.setText("");
			fufsenha.setText("");
			fufresenha.setText("");
			
		}
		if (e.getSource().equals(this.fubsair)) {
			dispose();
			new Tela_Menu();
		}
		if (e.getSource().equals(this.fublimpar)) {
			
			fufnome.setText("");
			fuftelefone.setText("");
			fufmatricula.setText("");
			fuflogin.setText("");
			fufsenha.setText("");
			fufresenha.setText("");
		}
	}
	
} 

