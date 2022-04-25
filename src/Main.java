
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            System.out.println("Waiting");
            Socket socket = serverSocket.accept();
            System.out.println("Connected");
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("HTTP/1.0 200 OK");
            printStream.println("Content-type: text/html");
            printStream.println();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            printStream.println("<meta http-equiv='refresh' content='1'>" + formatter.format(date));
            socket.close();
        }
    }
}
