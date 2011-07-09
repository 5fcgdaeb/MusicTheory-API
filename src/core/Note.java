package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Note implements Comparable<Note> {
	
	public static Note A = new Note("A","A", NoteType.NATURAL, 1, null);
	public static Note B = new Note("B","B", NoteType.NATURAL, 3, null);
	public static Note C = new Note("C","C", NoteType.NATURAL, 4, null);
	public static Note D = new Note("D","D", NoteType.NATURAL, 6, null);
	public static Note E = new Note("E","E", NoteType.NATURAL, 8, null);
	public static Note F = new Note("F","F", NoteType.NATURAL, 9, null);
	public static Note G = new Note("G","G", NoteType.NATURAL, 11, null);
	
	public static Note Aflatflat = new Note("Abb","A flat flat", NoteType.ACCIDENTAL, 11, A);
	public static Note Aflat = new Note("Ab","A flat", NoteType.ACCIDENTAL, 12, A);
	public static Note ASharp = new Note("A#","A sharp", NoteType.ACCIDENTAL, 2, A);
	public static Note ASharpSharp = new Note("A##","A sharp sharp", NoteType.ACCIDENTAL, 3, A);
	
	public static Note Bflatflat = new Note("Bbb","B flat flat", NoteType.ACCIDENTAL, 1, B);
	public static Note Bflat = new Note("Bb","B flat", NoteType.ACCIDENTAL, 2, B);
	public static Note BSharp = new Note("B#","B sharp", NoteType.ACCIDENTAL, 4, B);
	public static Note BSharpSharp = new Note("B##","B sharp sharp", NoteType.ACCIDENTAL, 5, B);
	
	public static Note Cflatflat = new Note("Cbb","C flat flat", NoteType.ACCIDENTAL, 2, C);
	public static Note Cflat = new Note("Cb","C flat", NoteType.ACCIDENTAL, 3, C);
	public static Note CSharp = new Note("C#","C sharp", NoteType.ACCIDENTAL, 5, C);
	public static Note CSharpSharp = new Note("C##","C sharp sharp", NoteType.ACCIDENTAL, 6, C);
	
	public static Note Dflatflat = new Note("Dbb","D flat flat", NoteType.ACCIDENTAL, 4, D);
	public static Note Dflat = new Note("Db","D flat", NoteType.ACCIDENTAL, 5, D);
	public static Note DSharp = new Note("D#","D sharp", NoteType.ACCIDENTAL, 7, D);
	public static Note DSharpSharp = new Note("D##","D sharp sharp", NoteType.ACCIDENTAL, 8, D);
	
	public static Note Eflatflat = new Note("Ebb","E flat flat", NoteType.ACCIDENTAL, 6, E);
	public static Note Eflat = new Note("Eb","E flat", NoteType.ACCIDENTAL, 7, E);
	public static Note ESharp = new Note("E#","E sharp", NoteType.ACCIDENTAL, 9, E);
	public static Note ESharpSharp = new Note("E##","E sharp sharp", NoteType.ACCIDENTAL, 10, E);
	
	public static Note Fflatflat = new Note("Fbb","F flat flat", NoteType.ACCIDENTAL, 7, F);
	public static Note Fflat = new Note("Fb","F flat", NoteType.ACCIDENTAL, 8, F);
	public static Note FSharp = new Note("F#","F sharp", NoteType.ACCIDENTAL, 10, F);
	public static Note FSharpSharp = new Note("F##","F sharp sharp", NoteType.ACCIDENTAL, 11, F);
	
	public static Note Gflatflat = new Note("Gbb","G flat flat", NoteType.ACCIDENTAL, 9, G);
	public static Note Gflat = new Note("Gb","G flat", NoteType.ACCIDENTAL, 10, G);
	public static Note GSharp = new Note("G#","G sharp", NoteType.ACCIDENTAL, 12, G);
	public static Note GSharpSharp = new Note("G##","G sharp sharp", NoteType.ACCIDENTAL, 1, G);
	
	public static List<Note> allNotesWithinDefaultOctave = new ArrayList<Note>();
	
	public static List<Note> getAllNotesInDefaultOctave() {
		
		if(allNotesWithinDefaultOctave.size() == 0) {
			placeNotesInList();
		}
		
		return allNotesWithinDefaultOctave;
	}
	
	private static void placeNotesInList() {
		
		Note[] notes = {A,B,C,D,E,F,G,Aflatflat,Aflat,ASharp,ASharpSharp,
						Bflatflat,Bflat,BSharp,BSharpSharp,
						Cflatflat,Cflat,CSharp,CSharpSharp,
						Dflatflat,Dflat,DSharp,DSharpSharp,
						Eflatflat,Eflat,ESharp,ESharpSharp,
						Fflatflat,Fflat,FSharp,FSharpSharp,
						Gflatflat,Gflat,GSharp,GSharpSharp };
		
		allNotesWithinDefaultOctave.addAll(Arrays.asList(notes));
	}
	
	public static final int NUMBER_OF_NATURAL_NOTES = 7;
	public static final int MAXIMUM_NOTE_ID = 12;
	
	private final String englishDescription;
	private final String musicalNotation;
	private final int id;
	private final NoteType noteType;
	private final Note linkedNaturalNote;
	private final Octave octave;
	
	private Note(String musicalNotation, String englishDescription, NoteType noteType, int id,
				Note linkedNaturalNote) {
		this(musicalNotation, englishDescription, noteType, id, linkedNaturalNote, Octave.DEFAULT);
	}
	
	private Note(String musicalNotation, String englishDescription, NoteType noteType, int id,
				Note linkedNaturalNote, Octave octave) {
		this.englishDescription = englishDescription;
		this.musicalNotation = musicalNotation;
		this.id = id;
		this.noteType = noteType;
		this.linkedNaturalNote = linkedNaturalNote;
		this.octave = octave;
	}
	
	public String englishDescription() { return this.englishDescription; }
	public String musicalNotationDescription() { return this.musicalNotation; }
	public int id() { return this.id; }
	public NoteType noteType() { return this.noteType; }
	public Octave octave() { return this.octave; }
	
	public Note linkedNaturalNote() { 
		if(this.isNatural()) return this;
		else return this.linkedNaturalNote; 
	}

	public boolean isNatural() { return this.noteType == NoteType.NATURAL; }
	
	public Note setOctave(Octave newOctave) {
		return new Note(this.musicalNotation, this.englishDescription, this.noteType, this.id,
						this.linkedNaturalNote, newOctave);
	}
	public Note raise() {
		// TODO: Introduce octave
		return NoteOperations.findNoteWithIDLinkedToTheNaturalNote(this.id + 1, this.linkedNaturalNote());
	}
	
	public Note lower() {
		// TODO: Introduce octave
		return NoteOperations.findNoteWithIDLinkedToTheNaturalNote(this.id - 1, this.linkedNaturalNote());
	}

	public int compareTo(Note arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
