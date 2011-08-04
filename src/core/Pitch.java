package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pitch {
	
	public static Pitch A = new Pitch("A","A", PitchType.NATURAL, 1, null);
	public static Pitch B = new Pitch("B","B", PitchType.NATURAL, 3, null);
	public static Pitch C = new Pitch("C","C", PitchType.NATURAL, 4, null);
	public static Pitch D = new Pitch("D","D", PitchType.NATURAL, 6, null);
	public static Pitch E = new Pitch("E","E", PitchType.NATURAL, 8, null);
	public static Pitch F = new Pitch("F","F", PitchType.NATURAL, 9, null);
	public static Pitch G = new Pitch("G","G", PitchType.NATURAL, 11, null);
	
	public static Pitch Aflatflat = new Pitch("Abb","A flat flat", PitchType.ACCIDENTAL, 11, A);
	public static Pitch Aflat = new Pitch("Ab","A flat", PitchType.ACCIDENTAL, 12, A);
	public static Pitch ASharp = new Pitch("A#","A sharp", PitchType.ACCIDENTAL, 2, A);
	public static Pitch ASharpSharp = new Pitch("A##","A sharp sharp", PitchType.ACCIDENTAL, 3, A);
	
	public static Pitch Bflatflat = new Pitch("Bbb","B flat flat", PitchType.ACCIDENTAL, 1, B);
	public static Pitch Bflat = new Pitch("Bb","B flat", PitchType.ACCIDENTAL, 2, B);
	public static Pitch BSharp = new Pitch("B#","B sharp", PitchType.ACCIDENTAL, 4, B);
	public static Pitch BSharpSharp = new Pitch("B##","B sharp sharp", PitchType.ACCIDENTAL, 5, B);
	
	public static Pitch Cflatflat = new Pitch("Cbb","C flat flat", PitchType.ACCIDENTAL, 2, C);
	public static Pitch Cflat = new Pitch("Cb","C flat", PitchType.ACCIDENTAL, 3, C);
	public static Pitch CSharp = new Pitch("C#","C sharp", PitchType.ACCIDENTAL, 5, C);
	public static Pitch CSharpSharp = new Pitch("C##","C sharp sharp", PitchType.ACCIDENTAL, 6, C);
	
	public static Pitch Dflatflat = new Pitch("Dbb","D flat flat", PitchType.ACCIDENTAL, 4, D);
	public static Pitch Dflat = new Pitch("Db","D flat", PitchType.ACCIDENTAL, 5, D);
	public static Pitch DSharp = new Pitch("D#","D sharp", PitchType.ACCIDENTAL, 7, D);
	public static Pitch DSharpSharp = new Pitch("D##","D sharp sharp", PitchType.ACCIDENTAL, 8, D);
	
	public static Pitch Eflatflat = new Pitch("Ebb","E flat flat", PitchType.ACCIDENTAL, 6, E);
	public static Pitch Eflat = new Pitch("Eb","E flat", PitchType.ACCIDENTAL, 7, E);
	public static Pitch ESharp = new Pitch("E#","E sharp", PitchType.ACCIDENTAL, 9, E);
	public static Pitch ESharpSharp = new Pitch("E##","E sharp sharp", PitchType.ACCIDENTAL, 10, E);
	
	public static Pitch Fflatflat = new Pitch("Fbb","F flat flat", PitchType.ACCIDENTAL, 7, F);
	public static Pitch Fflat = new Pitch("Fb","F flat", PitchType.ACCIDENTAL, 8, F);
	public static Pitch FSharp = new Pitch("F#","F sharp", PitchType.ACCIDENTAL, 10, F);
	public static Pitch FSharpSharp = new Pitch("F##","F sharp sharp", PitchType.ACCIDENTAL, 11, F);
	
	public static Pitch Gflatflat = new Pitch("Gbb","G flat flat", PitchType.ACCIDENTAL, 9, G);
	public static Pitch Gflat = new Pitch("Gb","G flat", PitchType.ACCIDENTAL, 10, G);
	public static Pitch GSharp = new Pitch("G#","G sharp", PitchType.ACCIDENTAL, 12, G);
	public static Pitch GSharpSharp = new Pitch("G##","G sharp sharp", PitchType.ACCIDENTAL, 1, G);
	
	public static final int NUMBER_OF_NATURAL_PITCHES = 7;
	public static final int MAXIMUM_PITCH_ID = 11;
	
	public String englishDescription;
	public String musicalNotation;
	public int id;
	public PitchType pitchType;
	public Pitch linkedNaturalPitch;

	private Pitch(String musicalNotation, String englishDescription, PitchType noteType, int id,
				Pitch linkedNaturalPitch) {
		this.englishDescription = englishDescription;
		this.musicalNotation = musicalNotation;
		this.id = id;
		this.pitchType = noteType;
		this.linkedNaturalPitch = linkedNaturalPitch;
	}
	
	public String englishDescription() { return this.englishDescription; }
	public String musicalNotationDescription() { return this.musicalNotation; }
	public int id() { return this.id; }
	public PitchType noteType() { return this.pitchType; }
	public Pitch linkedNaturalPitch() { 
		if(this.isNatural()) return this;
		else return this.linkedNaturalPitch; 
	}
	public boolean isNatural() { return this.pitchType == PitchType.NATURAL; }
	
	public boolean equals(Object otherObject) {
		if(!(otherObject instanceof Pitch)) return false;
		
		Pitch otherPitch = (Pitch) otherObject;
		
		return this.id() == otherPitch.id() && this.noteType() == otherPitch.noteType() &&
				this.linkedNaturalPitch().id() == otherPitch.linkedNaturalPitch().id();
	}
	
	public String toString() {
		return this.englishDescription;
	}
	
	public static List<Pitch> allPitches = new ArrayList<Pitch>();
	
	public static List<Pitch> getAllPitches() {
		
		if(allPitches.size() == 0) {
			insertPitchesInList();
		}
		
		return allPitches;
	}
	
	private static void insertPitchesInList() {
		
		Pitch[] pitches = {A,B,C,D,E,F,G,
						Aflatflat,Aflat,ASharp,ASharpSharp,
						Bflatflat,Bflat,BSharp,BSharpSharp,
						Cflatflat,Cflat,CSharp,CSharpSharp,
						Dflatflat,Dflat,DSharp,DSharpSharp,
						Eflatflat,Eflat,ESharp,ESharpSharp,
						Fflatflat,Fflat,FSharp,FSharpSharp,
						Gflatflat,Gflat,GSharp,GSharpSharp };
		
		allPitches.addAll(Arrays.asList(pitches));
	}
	
}