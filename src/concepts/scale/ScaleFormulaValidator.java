package concepts.scale;

import java.util.List;

import concepts.Interval;

public class ScaleFormulaValidator {
	
	private final List<Interval> intervals;
	private String validationProblem;
	
	public ScaleFormulaValidator(List<Interval> intervals) {
		this.intervals = intervals;
		this.validationProblem = null;
	}
	
	public String getValidationProblem() {
		return validationProblem;
	}

	public boolean canScaleBeCreated() {
		
		if(!areBasicRequirementsSatisfied()) { // size and OCTAVE & UNISON
			return false;
		} 
		
		if(!areIntervalsLessThanOctave()) {
			return false;
		}
		
		return true;
	}

	private boolean areBasicRequirementsSatisfied() {
		
		if(intervals == null || intervals.size() < 2) {
			this.validationProblem = "A scale must consist of 2 or more intervals";
			return false;
		}
		
		if(!intervals.contains(Interval.UNISON) || !intervals.contains(Interval.OCTAVE)) {
			this.validationProblem = "UNISON and OCTAVE both must be a part of any scale";
			return false;
		}
		
		return true;
	}
	
	private boolean areIntervalsLessThanOctave() {
		for(Interval interval: intervals) {
			if(interval.compareTo(Interval.OCTAVE) > 0) {
				this.validationProblem = "A scale can only include intervals less than OCTAVE";
				return false;
			}
		}
		return true;
	}
}
