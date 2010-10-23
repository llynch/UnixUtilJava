package org.llserver.unixUtil;

import java.util.List;
import java.util.regex.Pattern;

public class Grep extends Unix {

	private boolean ignoreCase_ = false;
	private boolean invertMatch_ = false;
	
	public Grep(Unix unix)
	{
		setLines(unix.getLines());
	}
	
	public Grep match(String pattern)
	{
		List<String> newLines = newList();
		Pattern compiledPattern = createPattern(pattern);
		for (String line : getLines())
			if (compiledPattern.matcher(line).find() || invertMatch_)
				newLines.add(line);
		this.setLines(newLines);
		return this;
	}
	
	private Pattern createPattern(String pattern)
	{
		if (ignoreCase_)
			return Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		else
			return Pattern.compile(pattern);
	}
	
	public Grep ignoreCase()
	{
		ignoreCase_ = true;
		return this;
	}
	
	public Grep invertMatch()
	{
		invertMatch_ = true;
		return this;
	}
}
