package concepts;

public enum Interval implements Comparable<Interval>{
	
	UNISON("Unison","Unison", 0, 0),
	m2("m2","Minor Second", 1, 1),
	M2("M2","Major Second", 2, 1),
	m3("m3","Minor Third", 3, 2),
	M3("M3","Major Third", 4, 2),
	P4("P4","Perfect Fourth", 5, 3),
	P4Raised("P4#","Raised Perfect Fourth", 6, 3),
	P5Flat("P5b","Flat Perfect Fifth", 6, 4),
	P5("P5","Perfect Fifth",7, 4),
	P5Raised("P5#","Augmented Fifth", 8, 4),
	m6("m6","Minor Sixth", 8, 5),
	M6("M6","Major Sixth", 9, 5),
	m7("m7","Minor Seventh", 10, 6),
	M7("M7","Major Seventh", 11, 6),
	OCTAVE("OCTAVE","Octave",12, 7),
	m9("m9","Minor Ninth", 13, 8),
	M9("M9","Major Ninth", 14, 8),
	m11("m11","Minor Eleventh", 16, 10),
	M11("M11","Major Eleventh", 17, 10),
	m13("m13","Minor Thirteenth", 20, 12),
	M13("M13","Major Thirteenth", 21, 12);
	
	private final String musicalNotation;
	private final String englishDescription;
	private final int distanceInHalfSteps;
	private final int distanceInNotes;
	
	
	Interval(String musicalNotation, String englishDescription, int distanceInHalfSteps, int distanceInNotes) {
		this.musicalNotation = musicalNotation;
		this.englishDescription = englishDescription;
		this.distanceInHalfSteps = distanceInHalfSteps;
		this.distanceInNotes = distanceInNotes;
	}
	
	public String musicalNotation() { return musicalNotation; }
	public String englishDescription() { return englishDescription; }
	public int distanceInHalfSteps() { return distanceInHalfSteps; }
	public int distanceInNotes() { return distanceInNotes; }
	
}
