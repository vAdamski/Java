import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException{
        Server server = new Server(1234);
        server.runServer();
    }
}
