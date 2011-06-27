package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import core.Note;
import core.NoteOperations;
import core.NoteType;

public class NoteOperationTests {
	
	@Test
	public void findNotesByIDReturnsSeveralNotes() {		

		List<Note> notesWithID = NoteOperations.findNotesWithID(7);
		
		assertTrue("Several notes should exist for this ID", notesWithID.size() > 1);
		
	}
	
	@Test
	public void findNotesByIDWithNonExistantID() {		

		List<Note> notesWithID = NoteOperations.findNotesWithID(23);
		
		assertTrue("No notes should exist for this ID", notesWithID.size() == 0);
		
	}
	
	@Test
	public void getAllNaturalNotesTest() {		

		List<Note> noAccidentalNotes = NoteOperations.getAllNaturalNotes();
		
		for(Note note: noAccidentalNotes){ 
			assertTrue("This note should be A,B,C,D,E,F or G", note.noteType() == NoteType.NATURAL);
		}	
	}
	
	@Test
	public void addToNaturalNoteTestWithSimpleAddition() {		

		Note newNote = NoteOperations.addNotesToNaturalNote(Note.A, 2);

		assertEquals("Adding 2 notes to A should give C", newNote,Note.C);

	}
	
	@Test
	public void addToNaturalNoteTestWithComplexAddition() {		

		Note newNote = NoteOperations.addNotesToNaturalNote(Note.D, 12);

		assertEquals("Adding 12 notes to D should give B", newNote, Note.B);

	}
	
	@Test
	public void addToNaturalNoteTestExceptionThrow() {		

		boolean exceptionThrown = false;
		Note newNote = null;
		
		try {
			newNote = NoteOperations.addNotesToNaturalNote(Note.Dflat, 12);
		}
		catch(IllegalArgumentException ex){ 
			exceptionThrown = true;
		}

		assertNull(newNote);
		assertTrue("Method shouldn't accept accidental notes", exceptionThrown);

	}
	
	@Test
	public void reduceLocationTests() {		

		int reducedLocation = NoteOperations.reduceLocationToWithinRange(12);
		assertEquals("12 should be reduced to 12", reducedLocation, 12);
		
		reducedLocation = NoteOperations.reduceLocationToWithinRange(23);
		assertEquals("23 should be reduced to 11", reducedLocation, 11);
		
		reducedLocation = NoteOperations.reduceLocationToWithinRange(0);
		assertEquals("0 should be reduced to 0", reducedLocation, 0);
		
		reducedLocation = NoteOperations.reduceLocationToWithinRange(25);
		assertEquals("25 should be reduced to 1", reducedLocation, 1);

	}
	
	@Test
	public void findNoteByIDLinkedToTheNaturalNoteTestSuccess() {		

		Note resultingNote = NoteOperations.findNoteWithIDLinkedToTheNaturalNote(10, Note.F);
		assertEquals("Note with ID 10 and no accidental note F should be F#", resultingNote, Note.FSharp);

		resultingNote = NoteOperations.findNoteWithIDLinkedToTheNaturalNote(16, Note.B);
		assertEquals("Note with ID 16 and no accidental note B should be B#", resultingNote, Note.BSharp);
	
	}
	
	@Test
	public void findNoteByIDLinkedToTheNaturalNoteTestFail() {		
		
		Note resultingNote = NoteOperations.findNoteWithIDLinkedToTheNaturalNote(2, Note.G);
		assertEquals("Note with ID 2 and no accidental note G should be null", resultingNote, null);
	}

}
