package tomb.tuner.gui;

import net.miginfocom.swing.MigLayout;
import tomb.tuner.recorder.TunerRecorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 29/12/2013 Time: 13:36
 */
public class TunerGUI extends JFrame
{
  private JLabel deviceLabel;
  private JComboBox deviceName;
  private JButton recordButton;
  private JLabel noteLabel;
  private JTextField noteTextField;
  private boolean recording = false;
  private TunerRecorder tunerRecorder;
  private Util util;
  private ImageIcon recordingImage;
  private ImageIcon haltImage;
  private JLabel imageLabel;

  
  public TunerGUI()
  {
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

    tunerRecorder = new TunerRecorder();

    deviceLabel = new JLabel(  );
    deviceLabel.setText( "Device:" );

    deviceName = new JComboBox();
    deviceName.setPreferredSize( new Dimension( 20,5 ) );

    String[] desc = tunerRecorder.getAudioDeviceDescriptions();
    for(String s : desc) deviceName.addItem( s );

    recordButton = new JButton(  );
    recordButton.setText( "Record" );
    recordButton.addActionListener( new ActionListener()
    {
      @Override
      public void actionPerformed( final ActionEvent e )
      {
        handleRecordAction();
      }
    } );

    noteLabel = new JLabel(  );
    noteLabel.setText( "Note:" );

    noteTextField = new JTextField( );

    imageLabel = new JLabel(  );
    imageLabel.setIcon( haltImage );
    imageLabel.setSize( 50,50 );

  }

  private void initMIGLayouts()
  {
    MigLayout layout = new MigLayout(  );
    setLayout( layout );
    add( deviceLabel );
    add( deviceName, "wrap" );
    add(imageLabel);
    add(recordButton);
    pack();
  }


  private void handleRecordAction()
  {
    recording = !recording;
    if ( recording )
    {
      imageLabel.setIcon( recordingImage );
      recordButton.setText( "Stop" );
      tunerRecorder.record();
    }
    else
    {
      imageLabel.setIcon( haltImage );
      recordButton.setText( "Record" );
      tunerRecorder.stopRecording();
    }
  }

}
