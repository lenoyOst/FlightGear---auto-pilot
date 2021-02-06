package Commands;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Connect_command implements Command{
	private Socket aClient;
	@Override
	public void doCommand(String[] attr) {
		try {
			aClient = new Socket(attr[0] , Integer.parseInt(attr[1]));
		} catch (NumberFormatException | IOException e) {e.printStackTrace();}
	}
	public Socket getClient()
	{
		return this.aClient;
	}

}
