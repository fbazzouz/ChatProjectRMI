package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import commun.Emitter;
import commun.Receiver;

public class EmitterImpl extends UnicastRemoteObject implements Emitter{
	protected String pseudo_connecte;
	HashMap<String,Receiver> all_receivers;
	
	protected EmitterImpl(String pseudo) throws RemoteException {
		super();
		this.pseudo_connecte=pseudo;
		// TODO Auto-generated constructor stub
	}

	public void sendMessage(String to, String message)  throws RemoteException{
		all_receivers.get(to).receive(pseudo_connecte,message);
	}
	
}
