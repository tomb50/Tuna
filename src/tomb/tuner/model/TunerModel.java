package tomb.tuner.model;

import tomb.tuner.model.external.FFT;
import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 29/12/2013 Time: 14:11
 */
public class TunerModel
{
  private FFT fft;
  private static TunerModel instance = null;
  static Mixer.Info[] mixer_info = AudioSystem.getMixerInfo();
  private static boolean isRecording = false;
  private AudioFormat format;
  private DataLine.Info inInfo;
  private TargetDataLine microphoneLine;
  ByteArrayOutputStream out = new ByteArrayOutputStream();
  SourceDataLine playbacksound;
  byte[] data; //temp stream data
  byte[] datamod; // manuipluated data sent back to output stream
  float sampleRate = 44100.0F;


  public TunerModel()
  {

    format = new AudioFormat( AudioFormat.Encoding.PCM_SIGNED,
                              sampleRate, 16, 2, 4, sampleRate, false);
    inInfo = new DataLine.Info(TargetDataLine.class, format);

    try
    {
      microphoneLine = (TargetDataLine) AudioSystem.getLine( inInfo );
    }
    catch ( LineUnavailableException lue )
    {
    }

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
      sendToFFT(data.clone());
      out.write( data, 0, numBytesRead );
    }

    microphoneLine.stop();
    datamod = out.toByteArray();
    manipulateAudio();
  }

  private void sendToFFT( final byte[] data )
  {
    int n = upper_power_of_two( data.length);
    double[] y = new double[n];
    double[] x = new double[n];

    for(int i = 0; i<data.length; i++)
    {
      x[i] = (double) data[i];

    }
    fft = new FFT(n);
    fft.fft( x,y );

    boolean done = true;

    double[] magnitude = new double[n];
    double maxMagnitude = 0;
    double maxIndex = 0;

    for(int i = 0; i < magnitude.length; i++ )
    {
      magnitude[i] = Math.sqrt ( (x[i]*x[i]) + (y[i]*y[i]) );
      if(magnitude[i] > maxMagnitude)
      {
        maxMagnitude=magnitude[i];
        maxIndex=i;
      }
    }

    double frequency = (maxIndex * sampleRate)/n;

  }

  private int upper_power_of_two( int v)
{
  v--;
  v |= v >> 1;
  v |= v >> 2;
  v |= v >> 4;
  v |= v >> 8;
  v |= v >> 16;
  v++;
  return v;

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
    if(datamod !=null)
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
    playbacksound.stop();
    playbacksound.close();
     // datamod=null;
    }


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
