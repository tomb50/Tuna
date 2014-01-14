package tomb.tuner.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 05/01/2014 Time: 01:40
 */
public class Note
{
  public static enum NoteEnum
  {
    C, Db, D, Eb, E, F, Gb, G, Ab, A, Bb, B
  }
  private static HashMap<NoteEnum, HashSet> frequencyMap;
  //Based on A4 = 440hz
  private static Double[] c_frequencies = { 16.35, 32.70, 65.41, 130.81, 261.63, 523.25, 1046.50, 2093.00, 4186.01 };
  private static Double[] db_frequencies = { 17.32, 34.65, 69.30, 138.59, 277.18, 554.37, 1108.73, 2217.46, 4434.92 };
  private static Double[] d_frequencies = { 18.35, 36.71, 73.42, 146.83, 293.66, 587.33, 1174.66, 2349.32, 4698.64 };
  private static Double[] eb_frequencies = { 19.45, 38.89, 77.78, 155.56, 311.13, 622.25, 1244.51, 2489.02, 4978.03 };
  private static Double[] e_frequencies = { 20.60, 41.20, 82.41, 164.81, 329.63, 659.26, 1318.51, 2637.02 };
  private static Double[] f_frequencies = { 21.83, 43.65, 87.31, 174.61, 349.23, 698.46, 1396.91, 2793.83 };
  private static Double[] gb_frequencies = { 23.12, 46.25, 92.50, 185.00, 369.99, 739.99, 1479.98, 2959.96 };
  private static Double[] g_frequencies = { 24.50, 49.00, 98.00, 196.00, 392.00, 783.99, 1567.98, 3135.96 };
  private static Double[] ab_frequencies = { 25.96, 51.91, 103.83, 207.65, 415.30, 830.61, 1661.22, 3322.44 };
  private static Double[] a_frequencies = { 27.5, 55.00, 110.00, 220.00, 440.00, 880.00, 1760.00, 3520.00 };
  private static Double[] bb_frequencies = { 29.14, 58.27, 116.54, 233.08, 466.16, 932.33, 1864.66, 3729.31 };
  private static Double[] b_frequencies = { 30.87, 61.74, 23.47, 246.94, 493.88, 987.77, 1975.53, 3951.07 };

  static{
    populateFrequencyMap();
  }


  private NoteEnum noteEnum;
  private HashSet currentNoteFrequencies; // worker variable to avoid repeated reads from <code>frequencyMap</code>

  public Note( NoteEnum noteEnum )
  {
    this.noteEnum = noteEnum;
    currentNoteFrequencies = getFrequenciesForCurrentNote( noteEnum );
  }

  public NoteEnum getEnum()
  {
    return noteEnum;
  }

  private HashSet getFrequenciesForCurrentNote( final NoteEnum noteEnum )
  {
    return (HashSet<Double[]>) frequencyMap.get( noteEnum );
  }

  private static void populateFrequencyMap()
  {
    frequencyMap = new HashMap<NoteEnum, HashSet>();
    frequencyMap.put( NoteEnum.C, new HashSet( Arrays.asList( c_frequencies ) ) );
    frequencyMap.put( NoteEnum.Db, new HashSet( Arrays.asList( db_frequencies ) ) );
    frequencyMap.put( NoteEnum.D, new HashSet( Arrays.asList( d_frequencies ) ) );
    frequencyMap.put( NoteEnum.Eb, new HashSet( Arrays.asList( eb_frequencies ) ) );
    frequencyMap.put( NoteEnum.E, new HashSet( Arrays.asList( e_frequencies ) ) );
    frequencyMap.put( NoteEnum.F, new HashSet( Arrays.asList( f_frequencies ) ) );
    frequencyMap.put( NoteEnum.Gb, new HashSet( Arrays.asList( gb_frequencies ) ) );
    frequencyMap.put( NoteEnum.G, new HashSet( Arrays.asList( g_frequencies ) ) );
    frequencyMap.put( NoteEnum.Ab, new HashSet( Arrays.asList( ab_frequencies ) ) );
    frequencyMap.put( NoteEnum.A, new HashSet( Arrays.asList( a_frequencies ) ) );
    frequencyMap.put( NoteEnum.Bb, new HashSet( Arrays.asList( bb_frequencies ) ) );
    frequencyMap.put( NoteEnum.B, new HashSet( Arrays.asList( b_frequencies ) ) );
  }
}
