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
	
	@Test
	public void testGrepFirstChar() throws FileNotFoundException
	{
		List<String> actual = new Unix().cat("testData/lines").grep("l").getLines();
		
		@SuppressWarnings("serial")
		List<String> expected = new ArrayList<String>() {{
				add("line 1");
				add("line 2");
				add("line 3");
				add("line 4");
		}};
			
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRegex() throws FileNotFoundException
	{
		List<String> actual = new Unix().cat("testData/regex").grep(":").getLines();
		
		@SuppressWarnings("serial")
		List<String> expected = new ArrayList<String>() {{
				add("param1: one");
				add("param2: two");
		}};
			
		assertEquals(expected, actual);
	}
}
