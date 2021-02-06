package Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import code_interpreter.Parser;

public class Var_command implements Command {
	@Override
	public void doCommand(String[] attr) 
	{
		if(attr.length > 1)
		{
			if(attr[2] == "bind")// syntax : var varibaleName = bind simVar 
			{
				
			}
		}
		else // syntax : var varibaleName
			Parser.getInstance().getCurrentBlock().newVar(attr[0], null);
	}
	public void updateVar(String Name , Double value)
	{
		//instance.symbolTable.put(Name, value);
		//TODO
	}
	
}
