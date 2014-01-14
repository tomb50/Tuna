package tomb.tuner.controller;

import tomb.tuner.model.RecordAction;
import tomb.tuner.model.StopAction;
import tomb.tuner.model.TunerModel;
import tomb.tuner.view.TunerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 14/01/2014 Time: 11:58
 */
public class RecordListener implements ActionListener
{
  TunerController tunerController;

  protected RecordListener(TunerController tunerController)
  {
    this.tunerController = tunerController;
  }

  @Override
  public void actionPerformed( final ActionEvent e )
  {
   handleRecordAction();
  }

  private void handleRecordAction()
  {
    //todo move the recording flag out of view
    getTunerView().setRecording( !getTunerView().isRecording() );
    if ( getTunerView().isRecording() )
    {
      getTunerView().getImageLabel().setIcon( getTunerView().getRecordingImage() );
      getTunerView().getRecordButton().setText( "Stop" );
      new Thread(new RecordAction(getTunerModel())).start();
      //imageLabel.setIcon( recordingImage );
      //recordButton.setText( "Stop" );

    }
    else
    {
      getTunerView().getImageLabel().setIcon( getTunerView().getHaltImage() );
      getTunerView().getRecordButton().setText( "Record" );
      new Thread(new StopAction(getTunerModel())).start();
      //imageLabel.setIcon( haltImage );
      //recordButton.setText( "Record" );

    }
  }

  private TunerView getTunerView()
  {
    return tunerController.getTunerView();
  }

  private TunerModel getTunerModel()
  {
    return tunerController.getTunerModel();
  }



}
