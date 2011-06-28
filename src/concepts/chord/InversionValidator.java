package concepts.chord;

public class InversionValidator {

	private final Inversion inversionToBeAdded;
	private final ChordQuality chordQuality;
	
	public InversionValidator(ChordQuality chordQuality, Inversion inversion) {
		this.inversionToBeAdded = inversion;
		this.chordQuality = chordQuality;
	}
	
	public boolean canInversionBeApplied() {
		
		switch(inversionToBeAdded) {
			case NONE:
				return true;
			case FIRST:
				return chordQuality.includesThird();
			case SECOND:
				return chordQuality.includesFifth();
			case THIRD:
				return chordQuality.includesSeventh();
		}

		return false;
	}
}
