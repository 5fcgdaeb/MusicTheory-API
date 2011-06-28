package test;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculators.ChordCalculator;

import concepts.chord.Chord;
import concepts.chord.ChordQualityFactory;
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
}
