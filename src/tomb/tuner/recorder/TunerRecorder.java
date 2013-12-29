package tomb.tuner.recorder;

import javax.sound.sampled.*;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 29/12/2013 Time: 14:11
 */
public class TunerRecorder
{
  static Mixer.Info[] mixer_info = AudioSystem.getMixerInfo();
  private AudioFormat format;
  private DataLine.Info inInfo;
  private int bufferSize;

  public TunerRecorder()
  {
    format = new AudioFormat( 8000,8,1,true,true );
    inInfo = new DataLine.Info( TargetDataLine.class, format );
    bufferSize = (int) format.getSampleRate() * format.getFrameSize();
  }

  public static void main( String[] args )
  {
    TunerRecorder tn = new TunerRecorder();
  }

  public void record()
  {

  }

  public void stopRecording()
  {

  }
}
