import java.net.*;

public class udp_server
{
    public static void main(String args[]) throws Exception
    {
        DatagramSocket socket = new DatagramSocket(9876);

        byte reply[] = new byte[1024];
        DatagramPacket packet = new DatagramPacket(reply,reply.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        byte data[] = "hello client im the server".getBytes();
        DatagramPacket packet2 = new DatagramPacket(data,data.length,packet.getAddress(),packet.getPort());
        socket.send(packet2);

        socket.close();
    }
}