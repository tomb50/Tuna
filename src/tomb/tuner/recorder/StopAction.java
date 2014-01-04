package tomb.tuner.recorder;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 01/01/2014 Time: 19:29
 */
public class StopAction implements Runnable
{
  @Override
  public void run()
  {
    tunerRecorder.stopRecording();
  }

  private TunerRecorder tunerRecorder = TunerRecorder.getInstance();
}
