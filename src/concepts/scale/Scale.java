package concepts.scale;

import core.Note;

public class Scale {
	
	private ScaleFormula formula;
	private Note startingNote;
	
	public Scale(ScaleFormula formula, Note note) {
		this.formula = formula;
		this.startingNote = note;
	}
	
	public ScaleFormula getFormula() {
		return formula;
	}
	public Note getStartingNote() {
		return startingNote;
	}
}
