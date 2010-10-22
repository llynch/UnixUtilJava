package org.llserver.unixUtil;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.llserver.unixUtil.Unix;


public class TestGrep extends TestCase {
	
	@Test
	public void testSimpleGrep() throws FileNotFoundException
	{
		List<String> actual = new Unix().cat("testData/lines").grep("2").getLines();
		
		@SuppressWarnings("serial")
		List<String> expected = new ArrayList<String>() {{
				add("line 2");
		}};
			
		assertEquals(expected, actual);
	}

}
