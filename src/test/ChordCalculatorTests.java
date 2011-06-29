package test;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculators.ChordCalculator;

import concepts.chord.Chord;
import concepts.chord.ChordQualityFactory;
import concepts.chord.Inversion;
import core.Note;

public class ChordCalculatorTests {

	ChordCalculator calculator;
	@Before
	public void setUp() {
		calculator = new ChordCalculator();
	}
	
	@After
	public void tearDown() {
		calculator = null;
	}
	
	@Test
	public void testGettingNotesOfCMajor() {
		
		Chord cMajor = new Chord(ChordQualityFactory.MAJOR(), Note.C);
		
		List<Note> cMajorNotes = calculator.getNotesInChord(cMajor);
		
		assertEquals(cMajorNotes.get(0), Note.C);
		assertEquals(cMajorNotes.get(1), Note.E);
		assertEquals(cMajorNotes.get(2), Note.G);
		
	}
	
	@Test
	public void testGettingNotesOfCMajorRespectingInversion() {
		
		Chord cMajor = new Chord(ChordQualityFactory.MAJOR(), Note.C);
		cMajor.addInversion(Inversion.SECOND);
		
		List<Note> cMajorNotes = calculator.getNotesInChordRespectingInversion(cMajor);
		
		assertEquals(cMajorNotes.get(0), Note.G);
		assertEquals(cMajorNotes.get(1), Note.C);
		assertEquals(cMajorNotes.get(2), Note.E);
		
	}
	
	@Test
	public void testGettingNotesOfGDominant() {
		
		Chord gDominant = new Chord(ChordQualityFactory.DOMINANT(), Note.G);
		
		List<Note> gDominantNotes = calculator.getNotesInChordRespectingInversion(gDominant);
		
		assertEquals(gDominantNotes.get(0), Note.G);
		assertEquals(gDominantNotes.get(1), Note.B);
		assertEquals(gDominantNotes.get(2), Note.D);
		assertEquals(gDominantNotes.get(3), Note.F);
	}
	
}
