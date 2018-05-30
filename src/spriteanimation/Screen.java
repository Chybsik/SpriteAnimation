package spriteanimation;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import java.util.ArrayList;
import javax.imageio.ImageIO;

import javax.swing.JPanel;

/**
 *
 * @author Timur
 */
public class Screen extends JPanel implements KeyListener {

    BufferedImage background;

    BufferedImage[] walkingRight;
    BufferedImage[] walkingRight_mask;
    BufferedImage img;

    int SPRITE_SIZE;

    int xOrig;
    int yOrig;
    int xOrigPrev;
    int yOrigPrev;

    public Screen(SpriteSheet sp, SpriteSheet sp_mask) {
        addKeyListener(this);
        setFocusable(true);

        try {
            background = ImageIO.read(new File("C:\\Users\\Timur\\Desktop\\background.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        img = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);    //Result image
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                img.setRGB(x, y, background.getRGB(x, y));
            }
        }
        walkingRight = new BufferedImage[]{sp.getSprite(0, 2), sp.getSprite(2, 2)};
        walkingRight_mask = new BufferedImage[]{sp_mask.getSprite(0, 2), sp_mask.getSprite(2, 2)};
        SPRITE_SIZE = 32;
    }

    private BufferedImage getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int y = 0; y < SPRITE_SIZE; y++) {
            for (int x = 0; x < SPRITE_SIZE; x++) {
                img.setRGB(x + xOrigPrev, y + yOrigPrev, background.getRGB(x + xOrigPrev, y + yOrigPrev));
            }
        }

        for (int y = 0; y < SPRITE_SIZE; y++) {
            for (int x = 0; x < SPRITE_SIZE; x++) {
                if (walkingRight_mask[(xOrig + yOrig) % 2].getRGB(x, y) == Color.white.getRGB()) {
                    img.setRGB(x + xOrig, y + yOrig, walkingRight[(xOrig + yOrig) % 2].getRGB(x, y));
                }
            }
        }
        g.drawImage(getScaledImage(img, this.getWidth(), this.getHeight()), 0, 0, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                xOrigPrev = xOrig;
                xOrig--;
                xOrig = xOrig < 0 ? 0 : xOrig;
                repaint();
                break;
            case KeyEvent.VK_RIGHT:
                xOrigPrev = xOrig;
                xOrig++;
                repaint();
                break;
            case KeyEvent.VK_DOWN:
                yOrigPrev = yOrig;
                yOrig++;

                repaint();
                break;
            case KeyEvent.VK_UP:
                yOrigPrev = yOrig;
                yOrig--;
                yOrig = yOrig < 0 ? 0 : yOrig;
                repaint();
                break;
        }

//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
