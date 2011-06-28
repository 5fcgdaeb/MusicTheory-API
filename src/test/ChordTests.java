package test;

import static org.junit.Assert.*;
import org.junit.Test;

import concepts.chord.*;
import core.Note;

public class ChordTests {

	@Test
	public void testChordCreation() {
		Chord chord = new Chord(ChordQualityFactory.DIMINISHED(),Note.Aflat);
		assertNotNull(chord);
	}
	
	@Test
	public void testChordIsInverted() {
		Chord chord = new Chord(ChordQualityFactory.DIMINISHED(),Note.Aflat);
		chord.addInversion(Inversion.SECOND);
		assertTrue(chord.isInverted());
	}
	
	@Test
	public void testChordIsNotInverted() {
		Chord chord = new Chord(ChordQualityFactory.DIMINISHED(),Note.Aflat);
		assertFalse(chord.isInverted());
	}
}
