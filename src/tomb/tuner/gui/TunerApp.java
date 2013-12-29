package tomb.tuner.gui;

import java.awt.*;
import java.awt.image.renderable.RenderableImageProducer;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 29/12/2013 Time: 14:16
 */
public class TunerApp
{

  public static void main( String[] args )
  {
    EventQueue.invokeLater( new Runnable()
    {
      @Override
      public void run()
      {
        new TunerGUI().setVisible( true );
      }
    } );
  }
}
