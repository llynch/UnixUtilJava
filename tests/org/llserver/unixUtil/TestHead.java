package org.llserver.unixUtil;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.llserver.unixUtil.Unix;

import junit.framework.TestCase;


public class TestHead extends TestCase {
	@Test
	public void testSimpleHead() throws FileNotFoundException
	{
		List<String> actual = new Unix().cat("testData/lines").head(2).getLines();
		
		@SuppressWarnings("serial")
		List<String> expected = new ArrayList<String>() {{
				add("line 1");
				add("line 2");
		}};
		
		assertEquals(expected, actual);
	}
}
