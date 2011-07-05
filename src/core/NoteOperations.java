package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NoteOperations {
	
	public static int bringLocationToWithinRange(int location) {
		
		if(location > 0 && location < 13); // within range, take no action
		
		else if(location > 12) {
			while(location > 12) {
				location -= (Note.MAXIMUM_NOTE_ID);
			}
		}
		
		else {
			while(location < 1) {
				location += (Note.MAXIMUM_NOTE_ID);
			}
		}
		
		return location;
	}
	
	public static List<Note> getAllNaturalNotes() {
		
		List<Note> allNotes = Arrays.asList(Note.values());
		
		List<Note> resultingNotes = new ArrayList<Note>();
		
		for(Note note: allNotes) {
			if(note.noteType() == NoteType.NATURAL) {
				resultingNotes.add(note);
			}
		}
		
		return resultingNotes;
	}

	public static List<Note> findNotesWithID(int id) {
		
		List<Note> allNotes = Arrays.asList(Note.values());
		
		List<Note> resultingNotes = new ArrayList<Note>();
		
		for(Note note: allNotes) {
			if(note.id() == id) {
				resultingNotes.add(note);
			}
		}
		
		return resultingNotes;
	}
	
	public static Note findNoteWithIDLinkedToTheNaturalNote(int location, Note naturalNote) {
		
		location = NoteOperations.bringLocationToWithinRange(location);
		
		List<Note> allNotesWithNewNoteID = NoteOperations.findNotesWithID(location);
		
		for(Note noteWithRightNoteID: allNotesWithNewNoteID) {
			if(noteWithRightNoteID.linkedNaturalNote() == naturalNote)
				return noteWithRightNoteID;		
		}
		return null;
	}
	
	public static Note addNotesToNaturalNote(Note naturalNote, int distanceInNotes) {
		
		if(naturalNote.noteType() != NoteType.NATURAL)
			throw new IllegalArgumentException("Only natural notes can be provided");
		
		List<Note> allNaturalNotes = NoteOperations.getAllNaturalNotes();
		Collections.sort(allNaturalNotes);
		
		int locationOfCurrentNote = allNaturalNotes.indexOf(naturalNote);
		int locationOfNewNote = locationOfCurrentNote + distanceInNotes;
		int locationInModNumberOfNotes = locationOfNewNote % Note.NUMBER_OF_NATURAL_NOTES;
		
		return allNaturalNotes.get(locationInModNumberOfNotes);
		
	}
}
