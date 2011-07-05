package calculators;

import java.util.ArrayList;
import java.util.List;

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
	
	public Interval addIntervals(Interval interval1, Interval interval2) {
		
		return null;
	}
	
	public List<Interval> getIntervalsWithDistanceInNotesFromUnison(int distanceInNotesFromUnison) {
		List<Interval> intervals = new ArrayList<Interval>();
		
		for(Interval interval: Interval.values()) {
			if(interval.distanceInNotes() == distanceInNotesFromUnison) {
				intervals.add(interval);
			}
		}
		
		return intervals;
	}
	
	public List<Interval> getIntervalsWithDistanceInHalfStepsFromUnison(int distanceInHalfStepsFromUnison) {
		List<Interval> intervals = new ArrayList<Interval>();
		
		for(Interval interval: Interval.values()) {
			if(interval.distanceInHalfSteps() == distanceInHalfStepsFromUnison) {
				intervals.add(interval);
			}
		}
		
		return intervals;
	}
	
	public Interval getIntervalWithDistanceInHalfStepAndDistanceInNotesFromUnison(int distanceInHalfSteps,
																				  int distanceInNotes) {
		
		for(Interval interval: Interval.values()) {
			if(interval.distanceInHalfSteps() == distanceInHalfSteps &&
					interval.distanceInNotes() == distanceInNotes) {
				return interval;
			}
		}
		
		return null;
	}
	
}
