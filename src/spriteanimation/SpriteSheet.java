package spriteanimation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

    private  BufferedImage spriteSheet;
    private int TILE_SIZE;

    public SpriteSheet(String path,int TILE_SIZE){
        
        spriteSheet = null;
        this.TILE_SIZE = TILE_SIZE;
        
        try {
            spriteSheet = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite(int xGrid, int yGrid) {

        if (spriteSheet == null) {
            
        }

        return spriteSheet.getSubimage(xGrid * TILE_SIZE, yGrid * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

}