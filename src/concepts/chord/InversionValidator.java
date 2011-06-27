package concepts.chord;

public class InversionValidator {

	private final Inversion inversionToBeAdded;
	private final Chord chord;
	
	public InversionValidator(Chord chord, Inversion inversion) {
		this.inversionToBeAdded = inversion;
		this.chord = chord;
	}
	
	public boolean canInversionBeApplied() {
		
		switch(inversionToBeAdded) {
			
		case NONE:
			return true;
		case FIRST:
			return chord.getChordQuality().includesThird();
		case SECOND:
			return chord.getChordQuality().includesFifth();
		case THIRD:
			return chord.getChordQuality().includesSeventh();
		}

		return false;
	}
}
