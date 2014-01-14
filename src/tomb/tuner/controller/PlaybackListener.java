package tomb.tuner.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 14/01/2014 Time: 11:58
 */
public class PlaybackListener implements ActionListener
{
  TunerController tunerController;

  protected PlaybackListener(TunerController tunerController)
  {
    this.tunerController = tunerController;
  }

  @Override
  public void actionPerformed( final ActionEvent e )
  {
     handlePlaybackAction();
  }

  private void handlePlaybackAction()
  {
    tunerController.getTunerModel().playback();
    //tunerModel.playback();
  }
}
