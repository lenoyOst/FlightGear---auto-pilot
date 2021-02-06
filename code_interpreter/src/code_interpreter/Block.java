package code_interpreter;
//------------------------------------------------------------------------------------------------------------
//this class will represent a current while block and will be responsible for holding that block's variables.
//------------------------------------------------------------------------------------------------------------

import java.util.HashMap;

public class Block {
	private Block father;
	private HashMap<String, Double> symbolTable;
	private Block newLoop()//reached a loop command and opened a new Block
	{
		Block block = new Block();
		block.father = this;
		return block;
	}
	public Block getFather() {
		return father;
	}
	public void updateValue(String name , Double value)// for existing variables
	{
		if(symbolTable.containsKey(name)) {symbolTable.put(name, value);}
		else father.updateValue(name, value);
	}
	public void newVar(String name , Double value)
	{
		symbolTable.put(name, value);
	}
	public Boolean contaisVar(String name)
	{
		if(father == null) return symbolTable.containsKey(name);
		else return symbolTable.containsKey(name) || father.contaisVar(name);
	}
}
