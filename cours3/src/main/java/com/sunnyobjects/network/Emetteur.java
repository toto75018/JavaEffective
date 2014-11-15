package com.sunnyobjects.network;
import java.net.*;

/**
 * Cet �metteur �met une <code>String</code> Java s�rialis� et
 * num�rot�es � destination d'un r�cepteur dont on esp�re qu'il sera
 * rapidement d�bord�.
 * Le <a href="Emetteur.java.html">code source</a>.
 * @author Jean-Baptiste Yun�s
 * @date F�vrier 2013
 */
public class Emetteur {
  public static void main(String [] args) {
    try {
      DatagramSocket s = new DatagramSocket();
      String message = "Coucou";
      byte [] data = message.getBytes();
      
      
      DatagramPacket paquet = new DatagramPacket(data,data.length,
                                                 new InetSocketAddress("localhost",55678));
      s.send(paquet);
      System.out.println("["+message+"] sent");
    } catch(Exception ex) {
      ex.printStackTrace();
      System.exit(1);
    }
  }
}
