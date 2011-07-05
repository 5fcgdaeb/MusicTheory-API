package calculators;

import java.util.ArrayList;
import java.util.List;


import concepts.Interval;
import concepts.scale.Scale;

import core.Note;

public class ScaleCalculator {

	public List<Note> getNotesInScale(Scale scale) {
		
		List<Note> notesInTheScale = new ArrayList<Note>();
		
		Note baseNote = scale.getStartingNote();
		IntervalCalculator calculator = new IntervalCalculator();
		
		for(Interval interval: scale.getFormula().getIntervalsInTheFormula()) {
			notesInTheScale.add(calculator.addIntervalTo(baseNote, interval));
		}
		
		return notesInTheScale;
	}
	
	public List<Interval> getAllPossibleIntervalsInScale(Scale scale) {
		
		List<Interval> allPossibleIntervals = new ArrayList<Interval>();
		allPossibleIntervals.addAll(scale.getFormula().getIntervalsInTheFormula());
		
		IntervalCalculator calculator = new IntervalCalculator();
		
		for(Interval interval: scale.getFormula().getIntervalsInTheFormula()) {
			Interval calculatedInterval = calculator.addIntervals(Interval.OCTAVE, interval);
			if(calculatedInterval != null) {
				allPossibleIntervals.add(calculatedInterval);
			}
		}
		
		return allPossibleIntervals;
	}
}
