package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tela_Menu extends JFrame {

	private static final long serialVersionUID = 1L;

	Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();

	private int larguraTela;
	private int alturaTela;
	private Fundo fundo;
	private JLabel pesquisar;
	private JLabel venda;
	private JLabel cadastrar;
	private JLabel sair;
	private JLabel texto;
	

	public Tela_Menu(){

		larguraTela=(int)(screenSize.width*0.66);
		alturaTela=(int)(screenSize.height*0.66);

		setLayout(null);

		if(larguraTela>=896 && alturaTela>=503){

			fundo= new Fundo(new ImageIcon("img/back.png").getImage());
			fundo.addMouseMotionListener(new MouseAdapt());
			fundo.setBounds(-1, -20, larguraTela, alturaTela);
			getLayeredPane().add(fundo, new Integer(1));

		}

		texto = new JLabel(new ImageIcon("img/texto.png"));
		texto.setBounds(larguraTela-570, -340, 600, 800);
		getLayeredPane().add(texto, new Integer(2));
		
		
		pesquisar=new JLabel(new ImageIcon("img/pes1.png"));
		pesquisar.addMouseMotionListener(new MouseAdapt());
		pesquisar.addMouseListener(new MouseAdapt());
		pesquisar.setBounds(larguraTela-740, 160, 130, 130);
		getLayeredPane().add(pesquisar, new Integer(2));

		venda=new JLabel(new ImageIcon("img/ven1.png"));
		venda.addMouseMotionListener(new MouseAdapt());
		venda.addMouseListener(new MouseAdapt());
		venda.setBounds(larguraTela-880, 20, 130, 130);
		getLayeredPane().add(venda, new Integer(2));

		cadastrar=new JLabel(new ImageIcon("Img/cad1.png"));
		cadastrar.addMouseMotionListener(new MouseAdapt());
		cadastrar.addMouseListener(new MouseAdapt());
		cadastrar.setBounds(larguraTela-880, 320, 130, 130);
		getLayeredPane().add(cadastrar, new Integer(2));
		
		sair=new JLabel(new ImageIcon("img/sair1.png"));
		sair.addMouseMotionListener(new MouseAdapt());
		sair.addMouseListener(new MouseAdapt());
		sair.setBounds(larguraTela-100, 390, 80, 80);
		getLayeredPane().add(sair, new Integer(2));

		setTitle("TELA DE MENU");
		setSize(larguraTela,alturaTela);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}


	public class MouseAdapt extends MouseAdapter{

		
		public void mouseMoved(MouseEvent e){
			if(e.getSource()==pesquisar){

				pesquisar.setIcon(new ImageIcon("img/pes1.png"));
			}else{
				pesquisar.setIcon(new ImageIcon("img/pes2.png"));
			}

			if(e.getSource()==venda){
				venda.setIcon(new ImageIcon("img/ven1.png"));
			}else{
				venda.setIcon(new ImageIcon("img/ven2.png"));
			}

			if(e.getSource()==cadastrar){
				cadastrar.setIcon(new ImageIcon("img/cad1.png"));
			}else{
				cadastrar.setIcon(new ImageIcon("img/cad2.png"));
			}

			if(e.getSource()==sair){
				sair.setIcon(new ImageIcon("img/sair1.png"));
			}else{
				sair.setIcon(new ImageIcon("img/sair2.png"));
			}
		}


		public void mouseClicked(MouseEvent e){

			if(e.getButton()==MouseEvent.BUTTON1){
				if(e.getSource()==pesquisar){
					dispose();
    				new Tela_Menu();				
				}

				if(e.getSource()==venda){
					dispose();
					new Tela_Menu();

				}

				if(e.getSource()==cadastrar){
					dispose();
					Tela_Cadastros tabbedPaneFrame = new Tela_Cadastros();
					tabbedPaneFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					tabbedPaneFrame.setSize( 340, 450 );
					tabbedPaneFrame.setVisible( true ); 
					tabbedPaneFrame.setLocationRelativeTo(null);

				}

				if(e.getSource()==sair){		
					System.exit(0);
				}
			}
		}
	}

	public static void main(String[] args) {
		new Tela_Menu();
		
	}

}
