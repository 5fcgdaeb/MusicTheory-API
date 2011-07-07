package core;

public enum Note implements Comparable<Note> {
	
	A ("A","A", NoteType.NATURAL, 1, null),
	B ("B","B", NoteType.NATURAL, 3, null),
	C ("C","C", NoteType.NATURAL, 4, null),
	D ("D","D", NoteType.NATURAL, 6, null),
	E ("E","E", NoteType.NATURAL, 8, null),
	F ("F","F", NoteType.NATURAL, 9, null),
	G ("G","G", NoteType.NATURAL, 11, null),
	
	Aflatflat ("Abb","A flat flat", NoteType.ACCIDENTAL, 11, A),
	Aflat ("Ab","A flat", NoteType.ACCIDENTAL, 12, A),
	ASharp ("A#","A sharp", NoteType.ACCIDENTAL, 2, A),
	ASharpSharp ("A##","A sharp sharp", NoteType.ACCIDENTAL, 3, A),
	
	Bflatflat ("Bbb","B flat flat", NoteType.ACCIDENTAL, 1, B),
	Bflat ("Bb","B flat", NoteType.ACCIDENTAL, 2, B),
	BSharp ("B#","B sharp", NoteType.ACCIDENTAL, 4, B),
	BSharpSharp ("B##","B sharp sharp", NoteType.ACCIDENTAL, 5, B),
	
	Cflatflat ("Cbb","C flat flat", NoteType.ACCIDENTAL, 2, C),
	Cflat ("Cb","C flat", NoteType.ACCIDENTAL, 3, C),
	CSharp ("C#","C sharp", NoteType.ACCIDENTAL, 5, C),
	CSharpSharp ("C##","C sharp sharp", NoteType.ACCIDENTAL, 6, C),
	
	Dflatflat ("Dbb","D flat flat", NoteType.ACCIDENTAL, 4, D),
	Dflat ("Db","D flat", NoteType.ACCIDENTAL, 5, D),
	DSharp ("D#","D sharp", NoteType.ACCIDENTAL, 7, D),
	DSharpSharp ("D##","D sharp sharp", NoteType.ACCIDENTAL, 8, D),
	
	Eflatflat ("Ebb","E flat flat", NoteType.ACCIDENTAL, 6, E),
	Eflat ("Eb","E flat", NoteType.ACCIDENTAL, 7, E),
	ESharp ("E#","E sharp", NoteType.ACCIDENTAL, 9, E),
	ESharpSharp ("E##","E sharp sharp", NoteType.ACCIDENTAL, 10, E),
	
	Fflatflat ("Fbb","F flat flat", NoteType.ACCIDENTAL, 7, F),
	Fflat ("Fb","F flat", NoteType.ACCIDENTAL, 8, F),
	FSharp ("F#","F sharp", NoteType.ACCIDENTAL, 10, F),
	FSharpSharp ("F##","F sharp sharp", NoteType.ACCIDENTAL, 11, F),
	
	Gflatflat ("Gbb","G flat flat", NoteType.ACCIDENTAL, 9, G),
	Gflat ("Gb","G flat", NoteType.ACCIDENTAL, 10, G),
	GSharp ("G#","G sharp", NoteType.ACCIDENTAL, 12, G),
	GSharpSharp ("G##","G sharp sharp", NoteType.ACCIDENTAL, 1, G);
	
	public static final int NUMBER_OF_NATURAL_NOTES = 7;
	public static final int MAXIMUM_NOTE_ID = 12;
	
	private final String englishDescription;
	private final String musicalNotation;
	private final int id;
	private final NoteType noteType;
	private final Note linkedNaturalNote;
	
	Note(String musicalNotation, String englishDescription, NoteType noteType, int id,
		 Note linkedNaturalNote) {
		this.englishDescription = englishDescription;
		this.musicalNotation = musicalNotation;
		this.id = id;
		this.noteType = noteType;
		this.linkedNaturalNote = linkedNaturalNote;
	}
	
	public String englishDescription() { return this.englishDescription; }
	public String musicalNotationDescription() { return this.musicalNotation; }
	public int id() { return this.id; }
	public NoteType noteType() { return this.noteType; }
	
	public Note linkedNaturalNote() { 
		if(this.isNatural()) return this;
		else return this.linkedNaturalNote; 
	}

	public boolean isNatural() { return this.noteType == NoteType.NATURAL; }
	
	public Note raise() {
		return NoteOperations.findNoteWithIDLinkedToTheNaturalNote(this.id + 1, this.linkedNaturalNote());
	}
	
	public Note lower() {
		return NoteOperations.findNoteWithIDLinkedToTheNaturalNote(this.id - 1, this.linkedNaturalNote());
	}
}
