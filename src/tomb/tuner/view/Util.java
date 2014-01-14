package tomb.tuner.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 29/12/2013 Time: 14:59
 */
public class Util
{
  /** Returns an ImageIcon, or null if the path was invalid. */
  protected ImageIcon createImageIcon( String path,
                                       String description, int width, int height )
  {
    ImageIcon imageIcon = null;
    java.net.URL imgURL = getClass().getResource( path );
    try
    {
      Image img = ImageIO.read( imgURL );
      imageIcon = new ImageIcon( img.getScaledInstance( width, height, Image.SCALE_DEFAULT ) );
      imageIcon.setDescription( description );
    }
    catch ( IOException e )
    {
      System.err.print( "IOException when reading image for icon" );
    }


    return imageIcon;
  }
}
