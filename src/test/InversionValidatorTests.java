package test;

import static org.junit.Assert.*;
import org.junit.Test;

import concepts.Interval;
import concepts.chord.ChordQuality;
import concepts.chord.ChordQualityFactory;
import concepts.chord.Inversion;
import concepts.chord.InversionValidator;

public class InversionValidatorTests {

	@Test
	public void testAddingFirstInversionToMajorChord() {
		
		InversionValidator validator = new InversionValidator(ChordQualityFactory.MAJOR(), Inversion.FIRST);
		
		assertTrue(validator.canInversionBeApplied());
	}
	
	@Test
	public void testAddingSecondInversionToMajorChord() {
		
		InversionValidator validator = new InversionValidator(ChordQualityFactory.MAJOR(), Inversion.SECOND);
		
		assertTrue(validator.canInversionBeApplied());
	}
	
	@Test
	public void testAddingThirdInversionToSeventhChord() {
		
		ChordQuality seventhChordQuality = new ChordQuality(Interval.UNISON, Interval.m3, Interval.P5, Interval.m7);
		InversionValidator validator = new InversionValidator(seventhChordQuality, Inversion.THIRD);
		
		assertTrue(validator.canInversionBeApplied());
	}
	
	@Test
	public void testAddingFirstInversionToAPowerChord() {
		
		ChordQuality powerChordQuality = new ChordQuality(Interval.UNISON, Interval.P5);
		InversionValidator validator = new InversionValidator(powerChordQuality, Inversion.FIRST);
		
		assertFalse(validator.canInversionBeApplied());
	}
}
