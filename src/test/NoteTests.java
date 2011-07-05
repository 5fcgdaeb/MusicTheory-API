package test;

import static org.junit.Assert.*;
import org.junit.Test;
import core.Note;

public class NoteTests {
	
	@Test
	public void createNoteAndRetrieveFields() {
		
		assertEquals("A sharp's musical notation is wrong",
					Note.ASharp.musicalNotationDescription(),"A#");
		
		assertEquals("D has the wrong ID", Note.D.id(), 6);
		
	}
	
	@Test
	public void raiseCToCSharp() {
		assertEquals(Note.C.raise(), Note.CSharp);
	}
	
	@Test
	public void lowerCToCFlat() {
		assertEquals(Note.C.lower(), Note.Cflat);
	}
	
	@Test
	public void lowerCFlatToCFlatFlat() {
		assertEquals(Note.Cflat.lower(), Note.Cflatflat);
	}
}
