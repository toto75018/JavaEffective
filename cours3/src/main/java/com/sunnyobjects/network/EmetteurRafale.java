package com.sunnyobjects.network;
import java.net.*;

/**
 * Cet �metteur �met une rafale de <code>String</code> Java s�rialis� et
 * num�rot�es � destination d'un r�cepteur dont on esp�re qu'il sera
 * rapidement d�bord�.
 * Le <a href="EmetteurRafale.java.html">code source</a>.
 * @author Jean-Baptiste Yun�s
 * @date F�vrier 2013
 */
public class EmetteurRafale {
  public static void main(String [] args) {
    try {
      int n = 1;
      DatagramSocket s = new DatagramSocket();
      while (true) {
        String message = "Coucou "+n;
        n++;
        byte [] data = message.getBytes();
        DatagramPacket paquet = new DatagramPacket(data,data.length,
                                                   new InetSocketAddress("localhost",55678));
        s.send(paquet);
        System.out.println("["+message+"] sent");
      }
    } catch(Exception ex) {
      ex.printStackTrace();
      System.exit(1);
    }
  }
}
