package udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;


public class UDPSender {

	public static void main(String[] args) throws IOException {
		DatagramSocket porta = new DatagramSocket(9001);
		
		byte[] message = (args.length == 0) ? "1 - 2222222222222".getBytes() : args[0].getBytes();
					
		InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 9000);
		DatagramPacket packet = new DatagramPacket(message, message.length, address);
		
		porta.send(packet);
	}
}
