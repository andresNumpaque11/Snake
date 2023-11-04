
package view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class Background extends JPanel{
    
    private Image BackgroundImage;

    public Background(Image BackgroundImage) {
        this.BackgroundImage = BackgroundImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BackgroundImage, 0, 0, this);
    }

}
