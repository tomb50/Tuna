package tomb.tuner.view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 29/12/2013 Time: 13:36
 */
public class TunerView extends JFrame
{
  private JLabel deviceLabel;
  private JComboBox deviceName;
  private JButton recordButton;
  private JLabel noteLabel;
  private JTextField noteTextField;
  private boolean recording = false;
  private Util util;
  private ImageIcon recordingImage;
  private ImageIcon haltImage;
  private JLabel imageLabel;
  private JButton playbackButton; // for testing audio capturing

  
  public TunerView()
  {
    setVisible( true );
    initUtil();
    initComponents();
    initMIGLayouts();
  }

  private void initUtil()
  {
    util = new Util();
    recordingImage = util.createImageIcon( "resources/stop.png","Icon displayed when recording recording",50,50 );
    haltImage = util.createImageIcon( "resources/go.jpg","Icon displayed when not recording",50,50 );
  }

  private void initComponents()
  {
    setTitle( "Tomb Instrument Tuner!" );
    setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    deviceLabel = new JLabel(  );
    deviceLabel.setText( "Device:" );
    deviceName = new JComboBox();
    deviceName.setPreferredSize( new Dimension( 20,5 ) );
    recordButton = new JButton(  );
    recordButton.setText( "Record" );
    playbackButton = new JButton(  );
    playbackButton.setText( "Playback!" );
    noteLabel = new JLabel(  );
    noteLabel.setText( "Note:" );
    noteTextField = new JTextField( );
    imageLabel = new JLabel(  );
    imageLabel.setIcon( haltImage );
    imageLabel.setSize( 50,50 );

  }

  public void addRecordListener(ActionListener al)
  {
   recordButton.addActionListener( al );
  }

  public void addPlaybackListener(ActionListener al)
  {
   playbackButton.addActionListener( al );
  }



  private void initMIGLayouts()
  {
    MigLayout layout = new MigLayout(  );
    setLayout( layout );
    add( deviceLabel );
    add( deviceName, "wrap" );
    add(imageLabel);
    add(recordButton);
    add(playbackButton);
    pack();
  }

  public JLabel getImageLabel()
  {
    return imageLabel;
  }

  public void setImageLabel( final JLabel imageLabel )
  {
    this.imageLabel = imageLabel;
  }

  public JButton getRecordButton()
  {
    return recordButton;
  }

  public void setRecordButton( final JButton recordButton )
  {
    this.recordButton = recordButton;
  }

  public ImageIcon getRecordingImage()
  {
    return recordingImage;
  }

  public void setRecordingImage( final ImageIcon recordingImage )
  {
    this.recordingImage = recordingImage;
  }

  public ImageIcon getHaltImage()
  {
    return haltImage;
  }

  public void setHaltImage( final ImageIcon haltImage )
  {
    this.haltImage = haltImage;
  }

  public JLabel getDeviceLabel()
  {
    return deviceLabel;
  }

  public void setDeviceLabel( final JLabel deviceLabel )
  {
    this.deviceLabel = deviceLabel;
  }

  public JComboBox getDeviceName()
  {
    return deviceName;
  }

  public void setDeviceName( final JComboBox deviceName )
  {
    this.deviceName = deviceName;
  }

  public JLabel getNoteLabel()
  {
    return noteLabel;
  }

  public void setNoteLabel( final JLabel noteLabel )
  {
    this.noteLabel = noteLabel;
  }

  public JTextField getNoteTextField()
  {
    return noteTextField;
  }

  public void setNoteTextField( final JTextField noteTextField )
  {
    this.noteTextField = noteTextField;
  }

  public boolean isRecording()
  {
    return recording;
  }

  public void setRecording( final boolean recording )
  {
    this.recording = recording;
  }

  public Util getUtil()
  {
    return util;
  }

  public void setUtil( final Util util )
  {
    this.util = util;
  }

  public JButton getPlaybackButton()
  {
    return playbackButton;
  }

  public void setPlaybackButton( final JButton playbackButton )
  {
    this.playbackButton = playbackButton;
  }
}
