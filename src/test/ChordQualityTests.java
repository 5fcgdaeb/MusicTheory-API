package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import concepts.Interval;
import concepts.chord.*;
import exceptions.BadChordQualityException;

public class ChordQualityTests {

	@Test
	public void testCreationOfChordQualityWithIntervalList() {
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(Interval.UNISON);
		intervals.add(Interval.m3);
		intervals.add(Interval.m6);
		
		ChordQuality quality = new ChordQuality(intervals);
		assertNotNull(quality);
	}
	
	@Test
	public void testCreationOfChordQualityWithIntervals() {
		
		ChordQuality quality = new ChordQuality(Interval.OCTAVE, Interval.UNISON);
		assertNotNull(quality);
		assertEquals(quality.getIntervalsInTheChord().size(), 2);
	}
	
	@Test
	public void testCreationOfInvalidChordQualityConstruction() {
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(Interval.m3);
		intervals.add(Interval.m6);
		
		ChordQuality quality = null;
		try {
			quality = new ChordQuality(intervals);
			fail();
		}
		catch(BadChordQualityException exception){
			assertNotNull(exception);
		}
		
		assertNull(quality);
	}
	
	@Test
	public void testOrderingOfIntervals() {
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(Interval.M11);
		intervals.add(Interval.UNISON);
		intervals.add(Interval.M3);
		intervals.add(Interval.P5);
		
		ChordQuality quality = new ChordQuality(intervals);
		assertEquals(quality.getIntervalsInTheChord().get(0), Interval.UNISON);
		assertEquals(quality.getIntervalsInTheChord().get(1), Interval.M3);
		
	}
	
	@Test
	public void testPreDefinedChordQualities(){
		
		assertTrue(ChordQualityFactory.MAJOR().containsInterval(Interval.M3));
		
	}
	
	@Test
	public void testInclusionOfThirdInBasicChordQualities() {
		assertTrue(ChordQualityFactory.MAJOR().includesThird());
		assertTrue(ChordQualityFactory.MINOR().includesThird());
		assertTrue(ChordQualityFactory.DIMINISHED().includesThird());
	}
	
	@Test
	public void testInclusionOfFifthsInBasicChordQualities() {
		assertTrue(ChordQualityFactory.MAJOR().includesFifth());
		assertTrue(ChordQualityFactory.MINOR().includesFifth());
		assertTrue(ChordQualityFactory.DIMINISHED().includesFifth());
	}
}
