package tomb.tuner.model.external;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 16/01/2014 Time: 12:15
 */
public class TestBed
{
  public static void main( String[] args )
  {  int i16 = upper_power_of_two( 12 );
    int i4 = upper_power_of_two( 3 );
    int i256 = upper_power_of_two( 200 );
    int i16384 = upper_power_of_two( 8193 );


  }



  private static int upper_power_of_two( int v)
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

}
