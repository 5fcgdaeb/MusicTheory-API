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
}
