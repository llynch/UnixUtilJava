package org.llserver.unixUtil;
import java.io.FileNotFoundException;
import java.util.List;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import org.junit.Test;


public class TestGrep extends TestCase {
	
	@Test
	public void testSimpleGrep() throws FileNotFoundException
	{
		List<String> actual = new Unix().cat("testData/lines").grep("2").getLines();
		
		String[] expected = {
				"line 2"
		};
			
		assertAreSameArrays(expected, actual);
	}
	
	@Test
	public void testGrepFirstChar() throws FileNotFoundException
	{
		List<String> actual = new Unix().cat("testData/lines").grep("l").getLines();
		
		String[] expected = {
			"line 1",
			"line 2",
			"line 3",
			"line 4"
		};
			
		assertAreSameArrays(expected, actual);
	}
	
	@Test
	public void testRegex() throws FileNotFoundException
	{
		List<String> actual = new Unix().cat("testData/regex").grep(":").getLines();
		
		String[] expected = {
			"param1: one",
			"param2: two"
		};
			
		assertAreSameArrays(expected, actual);
	}
	
	public void testIgnoreCase() throws FileNotFoundException
	{
		List<String> actual = new Unix().cat("testData/regex").grep().ignoreCase().match("HELLO").getLines();
		
		String[] expected = {
				"hello world!"
		};
		
		assertAreSameArrays(expected, actual);
	}
	
	
	public void testIgnoreCaseInvertMatchRegex() throws FileNotFoundException
	{
		List<String> actual = new Unix().cat("testData/regex")
			.grep().ignoreCase().invertMatch().match("paraM\\d:")
			.getLines();
		
		String[] expected = {
				"hello world!",
				"this is a file",
				"whit keys and values"
		};
		
		assertAreSameArrays(expected, actual);
	}
	
	public void testIgnoreCaseRegex() throws FileNotFoundException
	{
		List<String> actual = new Unix().cat("testData/regex")
			.grep().ignoreCase().match("paraM\\d:")
			.getLines();
		
		String[] expected = {
				"param1: one",
				"param2: two"
		};
		
		assertAreSameArrays(expected, actual);
	}
	
	
	public static void assertAreSameArrays(String[] expected, List<String> actual)
	{
		if (expected.length != actual.size())
			throw new AssertionFailedError("expected: " + arrayToString(expected) + 
					" but was: " + arrayToString(actual.toArray()));
		
		int i = 0;
		for (String expectedElement : expected)
		{
			if (!expectedElement.equals(actual.get(i)))
				throw new AssertionFailedError("expected: " + arrayToString(expected) + 
						" but was: " + arrayToString(actual.toArray()));
			i++;
		}
	}
	
	private static String arrayToString(Object[] array)
	{
		StringBuilder sb = new StringBuilder();
		for (Object element : array)
		{
			sb.append(element);
			sb.append(", ");
		}
		return sb.toString();
	}
}
