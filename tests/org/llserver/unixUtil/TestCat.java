package org.llserver.unixUtil;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.llserver.unixUtil.Unix;



public class TestCat extends TestCase {

	@Test
	public void testSimpleCat() throws FileNotFoundException
	{
		List<String> actual = new Unix().cat("testData/lines").getLines();
		
		@SuppressWarnings("serial")
		List<String> expected = new ArrayList<String>() {{
				add("line 1");
				add("line 2");
				add("line 3");
				add("line 4");
		}};
			
		assertEquals(expected, actual);
	}
}
