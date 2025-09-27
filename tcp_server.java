import java.io.*;
import java.util.*;
import java.net.*;
class tcp_server
{
    public static void main(String args[]) throws Exception
    {
        ServerSocket server = new ServerSocket(5000);
        Socket socket = server.accept();

       
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        out.println("Hello From Server !!!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String output = in.readLine();

        System.out.println(output);

    }
}
// in both the files teh reading and writing shoulf be alternate