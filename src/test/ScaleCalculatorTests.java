package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculators.ScaleCalculator;
import concepts.scale.Scale;
import concepts.scale.ScaleFormula;
import concepts.scale.ScaleFormulaFactory;
import core.Note;

public class ScaleCalculatorTests {

	ScaleCalculator calculator;
	
	@Before
	public void setUp() {
		calculator = new ScaleCalculator();
	}
	
	@After
	public void tearDown() {
		calculator = null;
	}
	
	@Test
	public void testGettingNotesOfCMajorScale() {
		
		ScaleFormula formula = ScaleFormulaFactory.MAJOR_SCALE();
		Scale cMajorScale = new Scale(formula, Note.C);
		
		List<Note> notesOfCMajorScale = calculator.getNotesInScale(cMajorScale);
		
		for(Note note: notesOfCMajorScale) {
			assertTrue(note.isNatural());
		}
		
		assertEquals(notesOfCMajorScale.get(0), Note.C);
		assertEquals(notesOfCMajorScale.get(1), Note.D);
		assertEquals(notesOfCMajorScale.get(2), Note.E);
		assertEquals(notesOfCMajorScale.get(3), Note.F);
		assertEquals(notesOfCMajorScale.get(4), Note.G);
		assertEquals(notesOfCMajorScale.get(5), Note.A);
		assertEquals(notesOfCMajorScale.get(6), Note.B);
		assertEquals(notesOfCMajorScale.get(7), Note.C);
		
		assertEquals(notesOfCMajorScale.size(), 8);
	}
	
}
