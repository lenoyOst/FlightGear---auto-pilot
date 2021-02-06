package code_interpreter;


public class Parser 
{
	private Server server;
	private Block currentBlock;
	private static Parser instance;
	private Parser() 
	{
		// TODO Auto-generated constructor stub
	}
	public static Parser getInstance() {
		if(instance ==  null) instance = new Parser();
		return instance;
	}
	public Block getCurrentBlock() {
		return currentBlock;
	}
	public Server getServer() {
		return server;
	}
}
