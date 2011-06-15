package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import client.console.CalculatorConsole;

public class UDPReceiver {

	
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(9000);
		byte[] buffer = new byte[256];
		InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 9000);
		DatagramPacket received = new DatagramPacket(buffer, buffer.length, address);
		while (true) {
			ds.receive(received);
			
			String msg = new String(received.getData(), 0, received.getLength());
			CalculatorConsole.main(msg.split(" "));
		}
		
	}
}
