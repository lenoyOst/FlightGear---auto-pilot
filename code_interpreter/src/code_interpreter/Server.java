package code_interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Observable;

import Commands.updatVarInfo;

public class Server extends Observable {
	private int port,rate;
	boolean stop = false;
	HashMap<String, Double> currantValue; // this will use use for saving all of the currant data that we read from the client (in our case the client is the FlightGear simulator)
	public Server(int port , int tPerSec)
	{
		this.port=port;
		this.rate= 1000/tPerSec;
	}
	public void openServer()
	{
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			Socket clientSocket = serverSocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			while (!in.ready()) {}
			while(!stop && in.ready())
			{
				//TODO
				Thread.sleep(rate);
			}
		} catch (IOException | InterruptedException e) {e.printStackTrace();}
	}
	public void stop()
	{
		stop=true;
	}
	public void updateSimVar(String name , Double value)
	{
		if(currantValue.get(name) != value)
		{
			//TODO
			updatVarInfo info = new updatVarInfo(name, value);
			notifyObservers(info);
		}
	}
}
