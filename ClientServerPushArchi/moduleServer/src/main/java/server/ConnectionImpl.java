package server;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import commun.Receiver;
import commun.Connection;
import commun.Emitter;

public class ConnectionImpl extends UnicastRemoteObject implements Connection{
	Set<String> clients;
	HashMap<String,Receiver> receivers;
	
    protected ConnectionImpl() throws RemoteException {
        super();
        clients = new HashSet<>();
        receivers = new HashMap<String,Receiver>();
        // TODO Auto-generated constructor stub
    }

    @Override
    public Emitter connect(String pseudo, Receiver rcv) throws RemoteException {
        if(!clients.contains(pseudo)) {
            EmitterImpl EmitterImplemente = new EmitterImpl(pseudo);
            clients.add(pseudo);
            rcv.initClients(clients);
            for (Receiver receiver : receivers.values()) {
                receiver.addClient(pseudo);
            }
            receivers.put(pseudo, rcv);
            EmitterImplemente.all_receivers = receivers;
            return EmitterImplemente;
        }
        else{
            return null;
        }
    }

    @Override
    public void disconnect(String  pseudo) throws RemoteException {
        clients.remove(pseudo);
        for(Receiver receiver : receivers.values()) {
            receiver.remClient(pseudo);
        }
    }
    
    @Override
    public String sayHello() throws RemoteException {
        // TODO Auto-generated method stub
        return "Hello world";
    }
}
