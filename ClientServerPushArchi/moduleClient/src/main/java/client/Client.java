package client;
import commun.Connection;
import commun.Emitter;
import commun.Receiver;

public class Client {
    /*
    public static void main(String[] args) throws RemoteException {
        // TODO Auto-generated method stub
    	String pseudo = "salima";
    	ReceiverImpl client_receiver = new ReceiverImpl();
    	Emitter client_emitter;
    	Connection myComponent;
        try {
            //example of a RMI URL use to retrieve a remote reference
            myComponent = (Connection) Naming.lookup("rmi://localhost:1079/Hello");
            client_emitter = myComponent.connect(pseudo, (Receiver) client_receiver);
            client_emitter.sendMessage("salima","salima hi");
            client_emitter.sendMessage("salima","salima test");
            System.out.println(client_receiver.messages);
            System.out.println(myComponent.sayHello());
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }*/

}
