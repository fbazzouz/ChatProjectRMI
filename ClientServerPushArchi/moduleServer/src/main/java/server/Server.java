package server;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        // registry creation
        LocateRegistry.createRegistry(1079);

        // component instanciation and implicit activation
        ConnectionImpl myComponent = new ConnectionImpl();

        System.out.println(myComponent.getRef().remoteToString());

        //publication of component reference in the registry
        Naming.rebind("rmi://localhost:1079/Hello", myComponent);

        System.out.println("Serveur actif");
        

    }

}
