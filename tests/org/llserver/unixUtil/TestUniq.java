package org.llserver.unixUtil;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.llserver.unixUtil.Unix;


public class TestUniq extends TestCase {

	@Test
	public void testSimpleUniq() throws FileNotFoundException
	{
		List<String> actual = new Unix().cat("testData/testUniq").uniq().getLines();
		
		@SuppressWarnings("serial")
		List<String> expected = new ArrayList<String>() {{
				add("line 1");
				add("line 2");
				add("line 3");
				add("line 4");
				add("line 5");
		}};
			
		assertEquals(expected, actual);
		
	}
}
