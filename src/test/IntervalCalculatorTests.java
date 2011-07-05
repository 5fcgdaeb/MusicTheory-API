package test;

import static org.junit.Assert.*;

import java.util.List;

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
	
	@Test
	public void testRetrievingIntervalsThatAddTenNotes() {
		List<Interval> intervalsTenNotesAbove = intervalCalculator.getIntervalsWithDistanceInNotes(10);
		
		assertEquals(intervalsTenNotesAbove.size(), 2);
		
		assertEquals(intervalsTenNotesAbove.get(0).distanceInHalfSteps(), 16);
		assertEquals(intervalsTenNotesAbove.get(1).distanceInHalfSteps(), 17);
	}
	
	@Test
	public void testRetrievingIntervalsThatAddSixHalfSteps() {
		List<Interval> intervalsSixHalfStepsAbove = intervalCalculator.getIntervalsWithDistanceInHalfSteps(6);
		
		assertEquals(intervalsSixHalfStepsAbove.size(), 2);
		
		assertEquals(intervalsSixHalfStepsAbove.get(0).distanceInNotes(), 3); // Raised Fourth
		assertEquals(intervalsSixHalfStepsAbove.get(1).distanceInNotes(), 4); // Diminished Fifth
	}
	
	@Test
	public void addMinorSecondToOctaveToGetMinorNinth() {
		Interval result = intervalCalculator.addIntervals(Interval.OCTAVE, Interval.m2);
		
		assertEquals(Interval.m9, result);
	}
	
	@Test
	public void addPerfectFifthToMajorSixthToGetNoResult() {
		Interval result = intervalCalculator.addIntervals(Interval.P5, Interval.M6);
		
		assertNull(result);
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
