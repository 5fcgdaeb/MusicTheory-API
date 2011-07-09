package core;

public enum Octave {
	
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	DEFAULT(3);
	
	private final int octaveCount;
	
	Octave(int count) {
		this.octaveCount = count;
	}
	
	public int getCount() {
		return this.octaveCount;
	}

}
