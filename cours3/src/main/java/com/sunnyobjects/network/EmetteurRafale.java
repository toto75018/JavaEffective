package com.sunnyobjects.network;
import java.net.*;

/**
 * Cet émetteur émet une rafale de <code>String</code> Java sérialisé et
 * numérotées à destination d'un récepteur dont on espère qu'il sera
 * rapidement débordé.
 * Le <a href="EmetteurRafale.java.html">code source</a>.
 * @author Jean-Baptiste Yunès
 * @date Février 2013
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
