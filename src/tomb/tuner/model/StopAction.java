package tomb.tuner.model;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 01/01/2014 Time: 19:29
 */
public class StopAction implements Runnable
{
  public StopAction(TunerModel tunerModel)
  {
    this.tunerModel = tunerModel;
  }
  @Override
  public void run()
  {
    tunerModel.stopRecording();
  }

  private TunerModel tunerModel;
}
