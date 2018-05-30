package spriteanimation;
  
public class SpriteAnimation
{
    public static void main(String[] args)
    {
        MainFrame f = new MainFrame();
        SpriteSheet image = new SpriteSheet("C:\\Users\\Timur\\Desktop\\wFRJj.png",32);
        SpriteSheet imageMask = new SpriteSheet("C:\\Users\\Timur\\Desktop\\wFRJj_mask.png",32);
        
        Screen s = new Screen(image,imageMask);
        f.add(s);
    }
}
 