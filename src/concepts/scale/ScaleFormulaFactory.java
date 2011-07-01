package concepts.scale;

import concepts.Interval;

public class ScaleFormulaFactory {
	
	public static ScaleFormula MAJOR_SCALE() {
		
		return new ScaleFormula(Interval.UNISON, Interval.M2, Interval.M3, 
										Interval.P4, Interval.P5, Interval.M6, Interval.M7, Interval.OCTAVE);
	}
	
	public static ScaleFormula MINOR_SCALE() {
		
		return new ScaleFormula(Interval.UNISON, Interval.M2, Interval.m3, 
										Interval.P4, Interval.P5, Interval.m6, Interval.m7, Interval.OCTAVE);
	}

}
