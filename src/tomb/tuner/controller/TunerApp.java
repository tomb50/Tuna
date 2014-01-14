package tomb.tuner.controller;

import tomb.tuner.model.TunerModel;
import tomb.tuner.view.TunerView;

import java.awt.*;

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
       TunerController.getInstance( new TunerModel(), new TunerView() );
      }
    } );
  }
}
