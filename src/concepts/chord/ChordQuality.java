package concepts.chord;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import concepts.Interval;
import exceptions.BadChordQualityException;

public class ChordQuality {

	private final List<Interval> intervalsInTheChord;
	
	public ChordQuality(Interval...intervals){
		this(Arrays.asList(intervals));
	}
	
	public ChordQuality(List<Interval> intervalsInTheChord) {
		
		boolean hasValidQuality = new ChordQualityValidator(intervalsInTheChord).isChordQualityValid();
		
		if(!hasValidQuality)
			throw new BadChordQualityException("Provided chord quality is not valid");
		
		this.intervalsInTheChord = intervalsInTheChord;
		Collections.sort(this.intervalsInTheChord);
	}

	public List<Interval> getIntervalsInTheChord() {
		return intervalsInTheChord;
	}
	
	public boolean containsInterval(Interval interval) {
		return intervalsInTheChord.contains(interval);
	}
	
	public boolean includesThird() {
		return this.containsInterval(Interval.m3) || this.containsInterval(Interval.M3);
	}
	
	public boolean includesFifth() {
		return this.containsInterval(Interval.P5) || this.containsInterval(Interval.P5Flat) ||
				this.containsInterval(Interval.P5Raised);
	}
	
	public boolean includesSeventh() {
		return this.containsInterval(Interval.m7) || this.containsInterval(Interval.M7);
	}
		
}
