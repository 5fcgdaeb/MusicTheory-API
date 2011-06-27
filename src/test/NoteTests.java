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
}
