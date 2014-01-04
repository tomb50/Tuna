package tomb.tuner.recorder;

import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 29/12/2013 Time: 14:11
 */
public class TunerRecorder
{
  private static TunerRecorder instance = null;
  static Mixer.Info[] mixer_info = AudioSystem.getMixerInfo();
  private static boolean isRecording = false;
  private AudioFormat format;
  private DataLine.Info inInfo;
  private TargetDataLine microphoneLine;
  ByteArrayOutputStream out = new ByteArrayOutputStream();
  SourceDataLine playbacksound;
  byte[] data; //temp stream data
  byte[] datamod; // manuipluated data sent back to output stream

  public static TunerRecorder getInstance()
  {
    if ( instance == null )
    {
      instance = new TunerRecorder();
    }
    return instance;
  }

  protected TunerRecorder()
  {

    format = new AudioFormat( AudioFormat.Encoding.PCM_SIGNED,
                              44100.0F, 16, 2, 4, 44100.0F, false);
    inInfo = new DataLine.Info(TargetDataLine.class, format);

    try
    {
      microphoneLine = (TargetDataLine) AudioSystem.getLine( inInfo );
    }
    catch ( LineUnavailableException lue )
    {
    }
    ;
    data = new byte[microphoneLine.getBufferSize() / 5];
  }


  public void record()
  {
    int numBytesRead;
    isRecording = true;

    try
    {
      microphoneLine.open();
    }
    catch ( LineUnavailableException ignored )
    {
    }
    microphoneLine.start();

    while ( isRecording )
    {
      numBytesRead = microphoneLine.read( data, 0, data.length );
      out.write( data, 0, numBytesRead );
    }

    microphoneLine.stop();
    datamod = out.toByteArray();
    manipulateAudio();
  }

  private void manipulateAudio()
  {
   //  reverse( datamod );
  }


  public void stopRecording()
  {
    isRecording = false;
  }

  public String[] getAudioDeviceDescriptions()
  {
    String[] desc = new String[mixer_info.length];
    for ( int i = 0; i < mixer_info.length; i++ )
    {
      desc[i] = mixer_info[i].getDescription();
    }
    return desc;
  }

  public void playback()
  {

    try
    {
      playbacksound = AudioSystem.getSourceDataLine( format );
    }
    catch ( LineUnavailableException lue )
    {
    }
    try
    {
      playbacksound.open();
    }
    catch ( LineUnavailableException e )
    {
      e.printStackTrace();
    }
    playbacksound.start();
    playbacksound.write( datamod,0,datamod.length );

  }









   /******************************************************
   * *****************************************************
   * Will stick all the manipulation methods down here
   *
   *
   *
   *
    */


  public static void reverse(byte[] array) {
    if (array == null) {
      return;
    }
    int i = 0;
    int j = array.length - 1;
    byte tmp;
    while (j > i) {
      tmp = array[j];
      array[j] = array[i];
      array[i] = tmp;
      j--;
      i++;
    }
  }



}
