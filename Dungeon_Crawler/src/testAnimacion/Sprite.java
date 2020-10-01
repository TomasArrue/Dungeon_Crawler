package testAnimacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;




public class Sprite extends JFrame implements Runnable{

	int AnchoVentana = 1000;
	int AltoVentana = 1000;
	int posX = 100;
	int posY = 100;
	Image img;
	Thread hilo;
	int incremento = 0;
	BufferedImage bi;
	
	public Sprite() {
		setSize(AnchoVentana,AltoVentana);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("hola mundo");
		setResizable(false);
		hilo = new Thread(this);
		bi = new BufferedImage(AnchoVentana, AltoVentana, BufferedImage.TYPE_INT_RGB);
		Toolkit herramienta = Toolkit.getDefaultToolkit();
		img = herramienta.getImage(getClass().getResource("/imagenes/wolf.png"));
		hilo.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d;
		g.drawImage(bi, 0, 0, this);
		g2d = bi.createGraphics();
		g2d.fillRect(0, 0, AnchoVentana, AltoVentana);
		
		int mx = (incremento % 7)*90;
		int my = (incremento / 7)*90;
		
		g2d.drawImage(img, posX, posY, posX+90, posY+90, mx, my, mx+90, my+90, this);
		repaint();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			incremento++;
			
			posX = posX + 10;

			
			if(incremento > 20) {
				incremento = 0;
				posX = 100;
			}
		}
	}
	
	public static void main (String[]args) {
		new Sprite().setVisible(true);
	}
}
