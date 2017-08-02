package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

public class Fundo extends JPanel{

	private static final long serialVersionUID = 1L;
	private Image image;  

	public Fundo(Image image) {  
		this.image = image;  
	}  

	public void paintComponent(Graphics g) {  

		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(image, 0, 0, this);
		g.dispose();
	}  
}
