package tomb.tuner.recorder;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 01/01/2014 Time: 19:28
 */
public class RecordAction implements Runnable
{
  @Override
  public void run()
  {
    tunerRecorder.record();

  }
  TunerRecorder tunerRecorder = TunerRecorder.getInstance();
}
