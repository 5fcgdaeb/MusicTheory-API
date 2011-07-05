package calculators;

import java.util.ArrayList;
import java.util.List;

import concepts.Interval;

import core.Note;
import core.NoteOperations;

public class IntervalCalculator {

	public IntervalCalculator(){;}
	
	public Note addIntervalTo(Note note, Interval interval) {
		
		int locationOfNewNote = calculateLocationOfNewNote(note, interval);
		
		Note resultingNaturalNote = calculateResultingNaturalNote(note, interval);
		
		return NoteOperations.findNoteWithIDLinkedToTheNaturalNote(locationOfNewNote, resultingNaturalNote);
	}
	
	private int calculateLocationOfNewNote(Note note, Interval interval) {
		
		int locationOfNewNote = note.id() + interval.distanceInHalfSteps();
		
		return NoteOperations.bringLocationToWithinRange(locationOfNewNote);
	}
	
	private Note calculateResultingNaturalNote(Note note, Interval interval) {
		
		Note closestCurrentNaturalNote = note.linkedNaturalNote();
		
		return NoteOperations.addNotesToNaturalNote(closestCurrentNaturalNote, interval.distanceInNotes());
	}
	
	public Interval addIntervals(Interval interval1, Interval interval2) {
		
		int totalDistanceInHalfSteps = interval1.distanceInHalfSteps() + interval2.distanceInHalfSteps();
		int totalDistanceInNotes = interval1.distanceInNotes() + interval2.distanceInNotes();
		
		return getIntervalWithDistanceInHalfStepAndDistanceInNotes(totalDistanceInHalfSteps, totalDistanceInNotes);
	}
	
	public List<Interval> getIntervalsWithDistanceInNotes(int distanceInNotes) {
		List<Interval> intervals = new ArrayList<Interval>();
		
		for(Interval interval: Interval.values()) {
			if(interval.distanceInNotes() == distanceInNotes) {
				intervals.add(interval);
			}
		}
		
		return intervals;
	}
	
	public List<Interval> getIntervalsWithDistanceInHalfSteps(int distanceInHalfSteps) {
		List<Interval> intervals = new ArrayList<Interval>();
		
		for(Interval interval: Interval.values()) {
			if(interval.distanceInHalfSteps() == distanceInHalfSteps) {
				intervals.add(interval);
			}
		}
		
		return intervals;
	}
	
	public Interval getIntervalWithDistanceInHalfStepAndDistanceInNotes(int distanceInHalfSteps,
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
