package core;

public class Note implements Comparable<Note> {

	private final PitchClass pitchClass;
	private final Octave octave;
	private final int midiCode;
	
	public Note(String note) {
		this(note, Octave.DEFAULT);
	}
	public Note(String note, Octave octave) {
		this(findPitchClass(note), octave);
	}
	
	private static PitchClass findPitchClass(String note) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Note(PitchClass pitchClass, Octave octave) {
		this.pitchClass = pitchClass;
		this.octave = octave;
		this.midiCode = calculateMidiCode();
	}
	
	private int calculateMidiCode() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Octave octave() {return this.octave;}
	public String note() {return this.pitchClass.musicalNotation();}
	public int getMidiCode() {return this.midiCode;}
	
	public Note setOctave(Octave newOctave) {
		
		if(this.octave() == newOctave) return this;
		
		return new Note(this.pitchClass, newOctave);
	}

	// Everything should be equal
	public boolean equals(Object otherObject) {
		
		if(!(otherObject instanceof Note)) return false;
		
		Note otherNote = (Note) otherObject;
		
		return this.note().equals(otherNote.note()) && this.octave() == otherNote.octave();
	}

	// Comparison only on MIDI codes
	public int compareTo(Note otherNote) {
		return new Integer(this.midiCode).compareTo(new Integer(otherNote.getMidiCode()));
	}

	
	public String toString() {
		return this.pitchClass.englishDescription + " in octave:" + Integer.toString(this.octave().count());
	}
}
