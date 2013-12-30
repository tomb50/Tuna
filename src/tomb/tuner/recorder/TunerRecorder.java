package tomb.tuner.recorder;

import javax.sound.sampled.*;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 29/12/2013 Time: 14:11
 */
public class TunerRecorder
{
  static Mixer.Info[] mixer_info = AudioSystem.getMixerInfo();
  private static boolean isRecording = false;
  private AudioFormat format;
  private DataLine.Info inInfo;
  private int bufferSize;
  private TargetDataLine line;

  public TunerRecorder()
  {
    format = new AudioFormat( 8000, 8, 1, true, true );
    inInfo = new DataLine.Info( TargetDataLine.class, format );
    bufferSize = (int) format.getSampleRate() * format.getFrameSize();

    /*if ( !AudioSystem.isLineSupported( inInfo ) )
    {
      System.err.println( "Unsupported Line" );
    }
    // Obtain and open the line.
    try
    {
      line = (TargetDataLine) AudioSystem.getLine( inInfo );
      line.open( format );
    }
    catch ( LineUnavailableException ex )
    {
      ex.printStackTrace();
    } */
  }

  public static void main( String[] args )
  {
    TunerRecorder tn = new TunerRecorder();
  }

  public void record()
  {
    isRecording = true;
   /* byte[] data = new byte[line.getBufferSize()/5];
    int numBytesRead;
   // line.start();
    while(isRecording)
    {

     numBytesRead = line.read( data,0,data.length );
      //todo all the difficult parts
    } */

  }

  public void stopRecording()
  {
    isRecording = false;

  }

  public String[] getAudioDeviceDescriptions()
  {
   String[] desc = new String[mixer_info.length];
    for(int i=0;i<mixer_info.length;i++)
    {
      desc[i] = mixer_info[i].getDescription();
    }
    return desc;

  }
}
