package tomb.tuner.controller;

import tomb.tuner.model.TunerModel;
import tomb.tuner.view.TunerView;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 14/01/2014 Time: 11:47
 */


public class TunerController
{
  static TunerController instance = null;
  TunerView tunerView;
  TunerModel tunerModel;

  public TunerModel getTunerModel()
  {
    return tunerModel;
  }

  public void setTunerModel( final TunerModel tunerModel )
  {
    this.tunerModel = tunerModel;
  }


  public TunerView getTunerView()
  {
    return tunerView;
  }

  public void setTunerView( final TunerView tunerView )
  {
    this.tunerView = tunerView;
  }

  public static TunerController getInstance( TunerModel tunerModel, TunerView tunerView)
  {
    if ( instance == null )
    {
      instance = new TunerController(tunerModel,tunerView);
    }
    return instance;
  }

  protected TunerController(TunerModel tunerModel, TunerView tunerView)
  {
    this.tunerModel = tunerModel;
    this.tunerView = tunerView;

    tunerView.addPlaybackListener(new PlaybackListener(this));
    tunerView.addRecordListener( new RecordListener(this) );
    updateViewDeviceList();
  }

  private void updateViewDeviceList()
  {
    String[] desc = tunerModel.getAudioDeviceDescriptions();
    for(String s : desc) tunerView.getDeviceName().addItem( s );
  }



}
