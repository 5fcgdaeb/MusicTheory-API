package concepts.chord;

import concepts.Interval;

public class ChordQualityFactory {

	public static ChordQuality MAJOR() {
		return new ChordQuality(Interval.UNISON, Interval.M3, Interval.P5);
	}
	
	public static ChordQuality MINOR() {
		return new ChordQuality(Interval.UNISON, Interval.m3, Interval.P5);
	}
	
	public static ChordQuality DIMINISHED() {
		return new ChordQuality(Interval.UNISON, Interval.m3, Interval.P5Flat);
	}
}
