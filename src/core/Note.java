package core;

public class Note implements Comparable<Note> {

	
	private final Pitch pitch;
	private final Octave octave;
	
	public Note(Pitch pitch, Octave octave) {
		this.pitch = pitch;
		this.octave = octave;
	}
	
	public Octave octave() {return this.octave;}
	public Pitch pitch() {return this.pitch;}
	
	public Note setOctave(Octave newOctave) {
		
		if(this.octave() == newOctave) return this;
		
		return new Note(this.pitch, newOctave);
	}

	public boolean equals(Object otherObject) {
		
		if(!(otherObject instanceof Note)) return false;
		
		Note otherNote = (Note) otherObject;
		
		return this.pitch.equals(otherNote.pitch()) && this.octave() == otherNote.octave();
	}

	public int compareTo(Note otherNote) {
		
		if(this.equals(otherNote)) { return 0; }
		
		else if(NoteOperationsWithOctave.getAbsoluteLocation(this) > 
						NoteOperationsWithOctave.getAbsoluteLocation(otherNote)) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public String toString() {
		return this.pitch.englishDescription + " in octave:" + Integer.toString(this.octave().count());
	}
}
