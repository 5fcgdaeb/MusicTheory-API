package concepts.scale;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import concepts.Interval;
import exceptions.InvalidScaleException;

public class ScaleFormula {
	
	private List<Interval> intervalsInTheFormula;
	
	public ScaleFormula(Interval...intervals) {
		
		this.intervalsInTheFormula = Arrays.asList(intervals);
		
		validateScaleFormula();
		Collections.sort(this.intervalsInTheFormula);
		
	}

	public List<Interval> getIntervalsInTheFormula() {
		return intervalsInTheFormula;
	}

	private void validateScaleFormula() {
		ScaleFormulaValidator validator = new ScaleFormulaValidator(this.intervalsInTheFormula);
		if(!validator.canScaleBeCreated()) {
			throw new InvalidScaleException(validator.getValidationProblem());
		}
	}
}
