package concepts.chord;

import java.util.List;

import concepts.Interval;

public class ChordQualityValidator {
	
	private final List<Interval> intervalsInTheChord;
	
	public ChordQualityValidator(List<Interval> intervalsInTheChord) {
		this.intervalsInTheChord = intervalsInTheChord;
	}
	
	public boolean isChordQualityValid() {
		
		if(intervalsInTheChord.size() < 2)
			return false;
		
		if(!intervalsInTheChord.contains(Interval.UNISON))
			return false;
		
		return true;
	}
}
