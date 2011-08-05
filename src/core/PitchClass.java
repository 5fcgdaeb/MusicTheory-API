package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PitchClass {
	
	public static PitchClass A = new PitchClass("A","A", PitchType.NATURAL, 1, null);
	public static PitchClass B = new PitchClass("B","B", PitchType.NATURAL, 3, null);
	public static PitchClass C = new PitchClass("C","C", PitchType.NATURAL, 4, null);
	public static PitchClass D = new PitchClass("D","D", PitchType.NATURAL, 6, null);
	public static PitchClass E = new PitchClass("E","E", PitchType.NATURAL, 8, null);
	public static PitchClass F = new PitchClass("F","F", PitchType.NATURAL, 9, null);
	public static PitchClass G = new PitchClass("G","G", PitchType.NATURAL, 11, null);
	
	public static PitchClass Aflatflat = new PitchClass("Abb","A flat flat", PitchType.ACCIDENTAL, 11, A);
	public static PitchClass Aflat = new PitchClass("Ab","A flat", PitchType.ACCIDENTAL, 12, A);
	public static PitchClass ASharp = new PitchClass("A#","A sharp", PitchType.ACCIDENTAL, 2, A);
	public static PitchClass ASharpSharp = new PitchClass("A##","A sharp sharp", PitchType.ACCIDENTAL, 3, A);
	
	public static PitchClass Bflatflat = new PitchClass("Bbb","B flat flat", PitchType.ACCIDENTAL, 1, B);
	public static PitchClass Bflat = new PitchClass("Bb","B flat", PitchType.ACCIDENTAL, 2, B);
	public static PitchClass BSharp = new PitchClass("B#","B sharp", PitchType.ACCIDENTAL, 4, B);
	public static PitchClass BSharpSharp = new PitchClass("B##","B sharp sharp", PitchType.ACCIDENTAL, 5, B);
	
	public static PitchClass Cflatflat = new PitchClass("Cbb","C flat flat", PitchType.ACCIDENTAL, 2, C);
	public static PitchClass Cflat = new PitchClass("Cb","C flat", PitchType.ACCIDENTAL, 3, C);
	public static PitchClass CSharp = new PitchClass("C#","C sharp", PitchType.ACCIDENTAL, 5, C);
	public static PitchClass CSharpSharp = new PitchClass("C##","C sharp sharp", PitchType.ACCIDENTAL, 6, C);
	
	public static PitchClass Dflatflat = new PitchClass("Dbb","D flat flat", PitchType.ACCIDENTAL, 4, D);
	public static PitchClass Dflat = new PitchClass("Db","D flat", PitchType.ACCIDENTAL, 5, D);
	public static PitchClass DSharp = new PitchClass("D#","D sharp", PitchType.ACCIDENTAL, 7, D);
	public static PitchClass DSharpSharp = new PitchClass("D##","D sharp sharp", PitchType.ACCIDENTAL, 8, D);
	
	public static PitchClass Eflatflat = new PitchClass("Ebb","E flat flat", PitchType.ACCIDENTAL, 6, E);
	public static PitchClass Eflat = new PitchClass("Eb","E flat", PitchType.ACCIDENTAL, 7, E);
	public static PitchClass ESharp = new PitchClass("E#","E sharp", PitchType.ACCIDENTAL, 9, E);
	public static PitchClass ESharpSharp = new PitchClass("E##","E sharp sharp", PitchType.ACCIDENTAL, 10, E);
	
	public static PitchClass Fflatflat = new PitchClass("Fbb","F flat flat", PitchType.ACCIDENTAL, 7, F);
	public static PitchClass Fflat = new PitchClass("Fb","F flat", PitchType.ACCIDENTAL, 8, F);
	public static PitchClass FSharp = new PitchClass("F#","F sharp", PitchType.ACCIDENTAL, 10, F);
	public static PitchClass FSharpSharp = new PitchClass("F##","F sharp sharp", PitchType.ACCIDENTAL, 11, F);
	
	public static PitchClass Gflatflat = new PitchClass("Gbb","G flat flat", PitchType.ACCIDENTAL, 9, G);
	public static PitchClass Gflat = new PitchClass("Gb","G flat", PitchType.ACCIDENTAL, 10, G);
	public static PitchClass GSharp = new PitchClass("G#","G sharp", PitchType.ACCIDENTAL, 12, G);
	public static PitchClass GSharpSharp = new PitchClass("G##","G sharp sharp", PitchType.ACCIDENTAL, 1, G);
	
	public static final int NUMBER_OF_NATURAL_PITCHES = 7;
	public static final int MAXIMUM_PITCH_CLASS_ID = 11;
	
	public String englishDescription;
	public String musicalNotation;
	public int id;
	public PitchType pitchType;
	public PitchClass linkedNaturalPitch;

	private PitchClass(String musicalNotation, String englishDescription, PitchType pitchType, int id,
				PitchClass linkedNaturalPitch) {
		this.musicalNotation = musicalNotation;
		this.englishDescription = englishDescription;
		this.id = id;
		this.pitchType = pitchType;
		this.linkedNaturalPitch = linkedNaturalPitch;
	}
	
	public String englishDescription() { return this.englishDescription; }
	public String musicalNotation() { return this.musicalNotation; }
	public int id() { return this.id; }
	public PitchType pitchType() { return this.pitchType; }
	public PitchClass linkedNaturalPitch() { 
		if(this.isNatural()) return this;
		else return this.linkedNaturalPitch; 
	}
	public boolean isNatural() { return this.pitchType == PitchType.NATURAL; }
	
	public boolean equals(Object otherObject) {
		if(!(otherObject instanceof PitchClass)) return false;
		
		PitchClass otherPitchClass = (PitchClass) otherObject;
		
		return this.id() == otherPitchClass.id() && this.pitchType() == otherPitchClass.pitchType() &&
				this.linkedNaturalPitch().id() == otherPitchClass.linkedNaturalPitch().id();
	}
	
	public String toString() {
		return this.englishDescription;
	}
	
	public static List<PitchClass> allPitchClasses = new ArrayList<PitchClass>();
	
	public static List<PitchClass> getAllPitches() {
		
		if(allPitchClasses.size() == 0) {
			insertPitchClassesInList();
		}
		
		return allPitchClasses;
	}
	
	private static void insertPitchClassesInList() {
		
		PitchClass[] pitchClasses = {A,B,C,D,E,F,G,
						Aflatflat,Aflat,ASharp,ASharpSharp,
						Bflatflat,Bflat,BSharp,BSharpSharp,
						Cflatflat,Cflat,CSharp,CSharpSharp,
						Dflatflat,Dflat,DSharp,DSharpSharp,
						Eflatflat,Eflat,ESharp,ESharpSharp,
						Fflatflat,Fflat,FSharp,FSharpSharp,
						Gflatflat,Gflat,GSharp,GSharpSharp };
		
		allPitchClasses.addAll(Arrays.asList(pitchClasses));
	}
	
}