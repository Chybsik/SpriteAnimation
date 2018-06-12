package spriteanimation;
  
public class SpriteAnimation
{
    public static void main(String[] args)
    {
        MainFrame f = new MainFrame();
        SpriteSheet image = new SpriteSheet("D:\\temp\\super-mario-sprite.png",32);
        SpriteSheet imageMask = new SpriteSheet("D:\\temp\\super-mario-sprite_mask.png",32);
        
        Screen s = new Screen(image,imageMask);
        f.add(s);
    }
}
 