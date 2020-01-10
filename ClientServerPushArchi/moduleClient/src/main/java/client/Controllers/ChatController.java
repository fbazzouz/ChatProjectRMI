package client.Controllers;

import client.ReceiverImpl;
import commun.Connection;
import commun.Emitter;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ChatController {
    public TextField pseudo;
    public Pane chatPane;
    public Pane loginPane;
    public Button sendBtn;
    public ListView<String> messages;
    public ListView<String> clientList;
    public TextField messageToSend;
    public Button connectBtn;
    public Emitter client_emitter;
    public ReceiverImpl client_receiver;
    public Text userConnected;
    public Button btn_disconnect;
    Alert a = new Alert(Alert.AlertType.NONE);
    Connection myComponent;
    String newClient;

    public void handleButtonAction(ActionEvent actionEvent) throws IOException {

        Parent root;
        client_receiver = new ReceiverImpl();

        //create an object type of emitter ( where we are going to store our emitter)

        try {
            myComponent = (Connection) Naming.lookup("rmi://localhost:1079/Hello");
            //connect and get our emitter from the server
            newClient=pseudo.getText();
            client_emitter = myComponent.connect(newClient, client_receiver);
            if(client_emitter!=null) {

                userConnected.setText("Welcome:"+newClient);
                loginPane.setVisible(false);
                chatPane.setVisible(true);
                clientList.setItems(client_receiver.getClients());
                messages.setItems(client_receiver.getMessages());
            }
            else{
                a.setAlertType(Alert.AlertType.WARNING);
                a.setTitle("Deja Connecté");
                a.setContentText("L'utilisateur avec ce nom est deja connecté ");
                a.show();
            }
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }


    }

    public void handleSend(ActionEvent actionEvent) {
        sendMessageFunction();
    }

    public void handleEnter(KeyEvent keyEvent) {
        //pour envoyer les messages directement avec entrer
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            sendMessageFunction();
        }
    }
    public void sendMessageFunction(){
        try {
            if(messageToSend.getText().equals("")){
                a.setAlertType(Alert.AlertType.WARNING);
                a.setTitle("Message Vide");
                a.setContentText("Veuillez svp entrer un message");
            }
            else {
                client_emitter.sendMessage(clientList.getSelectionModel().getSelectedItem(), messageToSend.getText());
                client_receiver.receive("me", messageToSend.getText());
                messageToSend.clear();
            }

        }
        catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(ActionEvent actionEvent) throws RemoteException {
        myComponent.disconnect(newClient);
        loginPane.setVisible(true);
        chatPane.setVisible(false);
    }
}
