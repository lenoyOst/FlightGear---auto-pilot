package Commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import code_interpreter.Block;
import code_interpreter.Parser;
import code_interpreter.Server;

public class Bind_command implements Observer
{
	private HashMap<String, ArrayList<String>> bindedAttr;
	public void bind(String var , String simVar)
	{
		ArrayList<String> vars;
		
		if(bindedAttr.containsKey(var)){vars = bindedAttr.get(var);}
		else {vars = new ArrayList<>();}
		vars.add(simVar);
		bindedAttr.put(var, vars);
		
		if(bindedAttr.containsKey(simVar)){vars = bindedAttr.get(simVar);}
		else {vars = new ArrayList<>();}
		vars.add(var);
		bindedAttr.put(simVar, vars);
	}
	@Override
	public void update(Observable o, Object arg) 
	{
		if(arg instanceof updatVarInfo)
		{
			String name = ((updatVarInfo) arg).getName();
			Double value = ((updatVarInfo) arg).getValue();
			if(bindedAttr.containsKey(name))
			{
				if(Parser.getInstance().getCurrentBlock().contaisVar(name))
				{
					Server server = Parser.getInstance().getServer();
					for (String var : bindedAttr.get(name)) 
					{
						server.updateSimVar(var, value);
					}
				}
				else
				{
					Block block = Parser.getInstance().getCurrentBlock();
					for(String var : bindedAttr.get(name))
					{
						block.updateValue(var, value);
					}
				}
			}
		}
		
	}
}
