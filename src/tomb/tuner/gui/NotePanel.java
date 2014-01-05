package tomb.tuner.gui;

import javax.swing.*;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 05/01/2014 Time: 01:34
 */
public class NotePanel extends JPanel
{
  private HashSet<NoteSquare> noteSquares;

  public NotePanel()
  {
    noteSquares = new HashSet<NoteSquare>(  );
    populateNotes();

  }

  private void populateNotes()
  {
    noteSquares.add( new NoteSquare( new Note( Note.NoteEnum.C ) ) );
    noteSquares.add( new NoteSquare( new Note( Note.NoteEnum.Db ) ) );
    noteSquares.add( new NoteSquare( new Note( Note.NoteEnum.D ) ) );
    noteSquares.add( new NoteSquare( new Note( Note.NoteEnum.Eb ) ) );
    noteSquares.add( new NoteSquare( new Note( Note.NoteEnum.E ) ) );
    noteSquares.add( new NoteSquare( new Note( Note.NoteEnum.F ) ) );
    noteSquares.add( new NoteSquare( new Note( Note.NoteEnum.Gb ) ) );
    noteSquares.add( new NoteSquare( new Note( Note.NoteEnum.G ) ) );
    noteSquares.add( new NoteSquare( new Note( Note.NoteEnum.Ab ) ) );
    noteSquares.add( new NoteSquare( new Note( Note.NoteEnum.A ) ) );
    noteSquares.add( new NoteSquare( new Note( Note.NoteEnum.Bb ) ) );
    noteSquares.add( new NoteSquare( new Note( Note.NoteEnum.B ) ) );
  }
}


