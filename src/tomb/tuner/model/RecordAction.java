package tomb.tuner.model;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 01/01/2014 Time: 19:28
 */
public class RecordAction implements Runnable
{
  public RecordAction(TunerModel tunerModel)
  {
    this.tunerModel = tunerModel;
  }
  @Override
  public void run()
  {
    tunerModel.record();

  }
  TunerModel tunerModel;
}
