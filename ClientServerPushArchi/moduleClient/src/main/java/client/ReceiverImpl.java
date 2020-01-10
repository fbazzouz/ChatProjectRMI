package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import commun.Receiver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ReceiverImpl extends UnicastRemoteObject implements Receiver{
	//HashMap<String,ArrayList<String>> messages;
	ObservableList<String> clients_connected= FXCollections.observableArrayList();
	ObservableList<String> messages = FXCollections.observableArrayList();



	public ReceiverImpl() throws RemoteException {
		super();
		//messages= new HashMap<String, ArrayList<String>>();
		// TODO Auto-generated constructor stub
	}
	public void receive(String  from,String  message) throws RemoteException {
		/*if (!messages.containsKey(from)) {
            ArrayList<String> liste = new ArrayList<String>();
            messages.put(from, liste);
        }

        messages.get(from).add(message);
        */

		messages.add(from +":"+message);
	}
	public void initClients(Set<String> clients) throws RemoteException{
		clients_connected.addAll(clients);

	}
	public void addClient(String client) throws RemoteException{
		clients_connected.add(client);
	}
	public void remClient(String client) throws RemoteException{
		clients_connected.remove(client);
	}
	public ObservableList<String> getClients() {
		return clients_connected;
	}

	public void setClients(ObservableList<String> clients) {
		this.clients_connected = clients;
	}

	public ObservableList<String> getMessages() {
		return messages;
	}

	public void setMessages(ObservableList<String> messages) {
		this.messages = messages;
	}
}
