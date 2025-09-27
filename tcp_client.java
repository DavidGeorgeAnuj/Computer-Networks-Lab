import java.io.*;
import java.util.*;
import java.net.*;
class tcp_client
{
    public static void main(String args[]) throws Exception
    {
        Socket socket = new Socket("localhost",5000);//connet to srver

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String output = in.readLine();
        System.out.println(output);

        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        out.println("Hello from Client");


        socket.close();
    }
}