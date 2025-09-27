import java.net.*;

public class udp_client
{
    public static void main(String args[]) throws Exception
    {
        DatagramSocket socket = new DatagramSocket();

        InetAddress server = InetAddress.getByName("localhost");
        byte data[] = "Hello Server i am the client".getBytes();
        DatagramPacket packet = new DatagramPacket(data,data.length,server,9876);
        socket.send(packet);

        byte reply[] = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(reply,reply.length);
        socket.receive(packet2);

        System.out.println(new String(packet2.getData(),0,packet2.getLength()));
        socket.close();

    }
}