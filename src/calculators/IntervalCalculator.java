package calculators;

import concepts.Interval;

import core.Note;
import core.NoteOperations;
import core.NoteType;

public class IntervalCalculator {

	public IntervalCalculator(){;}
	
	public Note addIntervalTo(Note note, Interval interval) {
		
		int locationOfNewNote = calculateLocationOfNewNote(note, interval);
		
		Note resultingNaturalNote = calculateResultingNaturalNote(note, interval);
		
		return NoteOperations.findNoteWithIDLinkedToTheNaturalNote(locationOfNewNote, resultingNaturalNote);
	}
	
	private int calculateLocationOfNewNote(Note note, Interval interval) {
		
		int locationOfNewNote = note.id() + interval.distanceInHalfSteps();
		
		return NoteOperations.reduceLocationToWithinRange(locationOfNewNote);
	}
	
	private Note calculateResultingNaturalNote(Note note, Interval interval) {
		
		Note closestCurrentNoAccidentalNote = null;
		if(note.noteType() == NoteType.NATURAL) closestCurrentNoAccidentalNote = note;
		else closestCurrentNoAccidentalNote = note.linkedNaturalNote();
		
		return NoteOperations.addNotesToNaturalNote(closestCurrentNoAccidentalNote, interval.distanceInNotes());
	}
	
}
