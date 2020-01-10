package commun;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface Receiver extends Remote{
	void receive(String  from,String  message) throws RemoteException;
	void initClients(Set<String> clients) throws RemoteException;
	void addClient(String client) throws RemoteException;
	void remClient(String client) throws RemoteException;
	
}
