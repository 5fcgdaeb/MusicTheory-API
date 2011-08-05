package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import core.Note;
import core.Octave;

public class NoteTests {
	
	@Test
	public void createNoteAndRetrieveFields() {
		
		assertEquals("A sharp's musical notation is wrong",
					Note.ASharp.musicalNotation(),"A#");
		
		assertEquals("D has the wrong ID", Note.D.id(), 6);
		
	}
	
	@Test
	public void identicalNotesShouldBeEqual() {
		
		assertTrue(Note.A.equals(Note.A));
	}
	
	@Test
	public void identicalNotesWithDifferentPointersShouldBeEqual() {
		
		Note note1 = Note.D.setOctave(Octave.ONE);
		Note note2 = Note.D.setOctave(Octave.ONE);
		assertTrue(note1.equals(note2));
	}
	
	@Test
	public void differentNotesShouldNotBeEqual() {
		
		assertFalse(Note.B.equals(Note.A));
	}
	
	@Test
	public void notesFromDifferentOctavesAreDifferent() {
		
		assertFalse(Note.A.equals(Note.A.setOctave(Octave.TEN)));
	}
	
	@Test
	public void sortRandomNotes() {
		List<Note> notes = new ArrayList<Note>();
		
		notes.add(Note.A);
		notes.add(Note.Aflatflat);
		notes.add(Note.D.setOctave(Octave.ONE));
		notes.add(Note.F.setOctave(Octave.TEN));
		
		Collections.sort(notes);
		
		assertEquals(Note.D.setOctave(Octave.ONE), notes.get(0));
		assertEquals(Note.Aflatflat, notes.get(1));
		assertEquals(Note.A, notes.get(2));
		assertEquals(Note.F.setOctave(Octave.TEN), notes.get(3));
	}
	
	@Test
	public void sortNotesWithSameID() {
		
	}
	
	
	
	
	
	
}
