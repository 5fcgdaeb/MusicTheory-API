package concepts.chord;

public enum Inversion {
	
	NONE(0),
	FIRST(1), // 3rd on bottom
	SECOND(2), // 5th on bottom
	THIRD(3); // 7th on bottom
	
	private final int orderOfBottomNote;
	
	Inversion(int order) {
		this.orderOfBottomNote = order;
	}
	
	public int getBottomNodeOrder() {
		return this.orderOfBottomNote;
	}
}
