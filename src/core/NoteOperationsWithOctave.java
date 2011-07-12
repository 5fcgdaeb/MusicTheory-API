package core;

public class NoteOperationsWithOctave {

	public static int getAbsoluteLocation(Note note) {
		return note.id() + (note.octave().count() * Note.MAXIMUM_NOTE_ID); 
	}
}
