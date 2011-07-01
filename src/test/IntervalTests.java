package test;

import static org.junit.Assert.*;
import org.junit.Test;

import concepts.Interval;


public class IntervalTests {
	
	@Test
	public void compareEqualityOfIntervals() {
		assertEquals(Interval.UNISON.compareTo(Interval.UNISON), 0);
	}
	
	@Test
	public void testMajorThirdBiggerThanMajorSecond() {
		assertTrue(Interval.M3.compareTo(Interval.M2) > 0);
	}
	
	@Test
	public void testMajorThirdLessThanMajorSeventh() {
		assertTrue(Interval.M3.compareTo(Interval.M7) < 0);
	}

}
