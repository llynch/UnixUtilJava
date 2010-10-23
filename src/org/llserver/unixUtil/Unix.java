package org.llserver.unixUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Unix {
	
	private List<String> lines = newList();
	
	public Unix()
	{
		
	}
	
	protected List<String> newList() {
		return new LinkedList<String>();
	}

	public Unix cat(String file) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new FileInputStream(file));
		while (scan.hasNext())
		{
			String line = scan.nextLine();
			this.lines.add(line);
		}
		scan.close();
		
		return this;
	}
	
	public Grep grep()
	{
		return new Grep(this);
	}
	
	public Unix grep(String pattern)
	{
		return new Grep(this).match(pattern);
	}
	
	public Unix head()
	{
		return this.head(10);
	}
	
	public Unix head(int n)
	{
		while (lines.size() > n)
			lines.remove(lines.size() - 1);
		return this;
	}
	
	public Unix sort()
	{
		Collections.sort(lines);
		return this;
	}
	
	public Unix sort(boolean reverse)
	{
		Collections.reverse(lines);
		return this;
	}
	
	public Unix tail()
	{
		return tail(10);
	}
	
	public Unix tail(int n)
	{
		while (lines.size() > n)
			lines.remove(0);
		return this; 
	}
	
	public Unix uniq()
	{
		lines = new LinkedList<String>(new LinkedHashSet<String>(lines));
		return this;
	}
	
	public List<String> getLines()
	{
		return this.lines;
	}
	
	protected void setLines(List<String> lines)
	{
		this.lines = lines;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (String line : lines)
		{
			sb.append(line);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
}
