package calculators;

import java.util.ArrayList;
import java.util.List;

import concepts.Interval;
import concepts.chord.Chord;
import concepts.chord.Inversion;
import core.Note;

public class ChordCalculator {

	public ChordCalculator() {}
	
	public List<Note> getNotesInChord(Chord chord) {
		
		List<Note> notesInChord = new ArrayList<Note>();
		IntervalCalculator calculator = new IntervalCalculator();
		
		for(Interval interval: chord.getChordQuality().getIntervalsInTheChord()) {
			notesInChord.add(calculator.addIntervalTo(chord.getBaseNote(), interval));
		}
		
		orderNotesUsingInversion(notesInChord, chord.getInversion());
		
		return notesInChord;
	}

	public void orderNotesUsingInversion(List<Note> notes, Inversion inversion) {
		if(inversion == Inversion.NONE) return;
		
	}
}
