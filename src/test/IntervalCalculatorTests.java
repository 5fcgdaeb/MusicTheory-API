package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import concepts.Interval;
import calculators.IntervalCalculator;
import core.Note;

public class IntervalCalculatorTests {
	
	private IntervalCalculator intervalCalculator;
	
	@Test
	public void addSimpleIntervalToNaturalNoteTest() {
		
		Note nextNote = intervalCalculator.addIntervalTo(Note.C, Interval.M2);
		assertEquals("Major second of C should be D.", nextNote, Note.D);
	}
	
	@Test
	public void addComplexIntervalToNaturalNoteTest() {
		
		Note nextNote = intervalCalculator.addIntervalTo(Note.C, Interval.m13);
		assertEquals("Minor thirteenth of C should be Ab.", nextNote, Note.Aflat);
	}
	
	@Test
	public void addMinorThirdToTestDoubleFlats() {
		
		Note nextNote = intervalCalculator.addIntervalTo(Note.Cflat, Interval.m3);
		assertEquals("Minor third of Cb should be Ebb.", nextNote, Note.Eflatflat);
	}
	
	@Test
	public void addMajorThirdToTestDoubleSharps() {
		
		Note nextNote = intervalCalculator.addIntervalTo(Note.DSharp, Interval.M3);
		assertEquals("Major third of D# should be F##.", nextNote, Note.FSharpSharp);
	}
	
	@Before
	public void setUp() {
		intervalCalculator = new IntervalCalculator();
	}
	
	@After
	public void tearDown() {
		intervalCalculator = null;
	}

}
