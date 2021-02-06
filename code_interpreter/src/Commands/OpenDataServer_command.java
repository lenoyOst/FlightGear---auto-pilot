package Commands;

import java.util.ArrayList;

import code_interpreter.Server;

public class OpenDataServer_command implements Command {
	@Override
	public void doCommand(String[] attr)
	{
		Server s = new Server(Integer.parseInt(attr[0]), Integer.parseInt(attr[1]));
		//open a new thread in which we call the openServer method that opens the server correctly
		new Thread(()->{s.openServer();}).start();
		
	}

}
