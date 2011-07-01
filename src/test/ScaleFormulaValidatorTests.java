package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import concepts.Interval;
import concepts.scale.ScaleFormulaValidator;

public class ScaleFormulaValidatorTests {

	@Test
	public void testValidatingMajorScaleSucceed() {
		List<Interval> majorScaleIntervals = Arrays.asList(Interval.UNISON, Interval.M2, Interval.M3, 
										Interval.P4, Interval.P5, Interval.M6, Interval.M7, Interval.OCTAVE);
		
		ScaleFormulaValidator validator = new ScaleFormulaValidator(majorScaleIntervals);
		
		assertTrue(validator.canScaleBeCreated());
	}
	
	@Test
	public void testValidatingOnlyUnisonFail() {
		List<Interval> onlyUnison = Arrays.asList(Interval.UNISON);
		
		ScaleFormulaValidator validator = new ScaleFormulaValidator(onlyUnison);
		
		assertFalse(validator.canScaleBeCreated());
	}
	
	@Test
	public void testValidatingEmptyListFail() {
		List<Interval> noElement = Arrays.asList();
		
		ScaleFormulaValidator validator = new ScaleFormulaValidator(noElement);
		
		assertFalse(validator.canScaleBeCreated());
	}
	
	@Test
	public void testValidatingIntervalsMoreThanOctaveFail() {
		List<Interval> listWithMinor11th = Arrays.asList(Interval.UNISON, Interval.M2, Interval.M3, 
										Interval.P4, Interval.P5, Interval.M6, Interval.M7, Interval.OCTAVE,
										Interval.m11);
		
		ScaleFormulaValidator validator = new ScaleFormulaValidator(listWithMinor11th);
		
		assertFalse(validator.canScaleBeCreated());
	}
}
