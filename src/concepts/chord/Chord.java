package concepts.chord;

import core.Note;
import exceptions.InvalidInversionException;

public class Chord {

	private final ChordQuality chordQuality;
	private final Note baseNote;
	private Inversion inversion;
	
	public Chord(ChordQuality chordQuality, Note baseNote) {
		this.chordQuality = chordQuality;
		this.baseNote = baseNote;
		this.inversion = Inversion.NONE;
	}

	public ChordQuality getChordQuality() {
		return chordQuality;
	}

	public Note getBaseNote() {
		return baseNote;
	}
	
	public Inversion getInversion() {
		return this.inversion;
	}
	
	public boolean isInverted() {
		return this.inversion != Inversion.NONE;
	}
	
	public void addInversion(Inversion inversion) {
		
		if(!new InversionValidator(this, inversion).canInversionBeApplied()) {
			throw new InvalidInversionException("Cannot apply the inverison to the chord");
		}
		
		this.inversion = inversion;
	}
}
