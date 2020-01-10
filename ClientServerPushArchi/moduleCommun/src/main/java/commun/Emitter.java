package commun;

import java.rmi.RemoteException;
import java.rmi.Remote;

public interface Emitter extends Remote{

	void sendMessage(String to, String message)  throws RemoteException;
}
