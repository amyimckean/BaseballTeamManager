package Views;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FieldPanel extends JPanel  {
	
	@Override
	 protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
    	File sourceimage = new File("src/Assets/BaseballField.jpg");
    	Image image;
		try {
			image = ImageIO.read(sourceimage);
	        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
