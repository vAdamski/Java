import Entity.Message;

import java.io.*;
import java.net.Socket;
import java.time.ZonedDateTime;

public class Client {
    private String Host;
    private int Port;
    private Socket socket = null;

    Client(String host, int port)
    {
        Host= host;
        Port = port;
    }

    public void runClient()
    {
        if(socket != null) return;

        try
        {
            socket = new Socket(Host, Port);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        System.out.println("You has been connected to server.");
    }

    public void disconnectClient()
    {
        if(socket == null) return;

        try
        {
            socket.close();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    public void SendMessageToServer(Message message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(message);
    }
}
