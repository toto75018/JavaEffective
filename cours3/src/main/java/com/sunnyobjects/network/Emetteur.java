package com.sunnyobjects.network;
import java.net.*;

/**
 * Cet émetteur émet une <code>String</code> Java sérialisé et
 * numérotées à destination d'un récepteur dont on espère qu'il sera
 * rapidement débordé.
 * Le <a href="Emetteur.java.html">code source</a>.
 * @author Jean-Baptiste Yunès
 * @date Février 2013
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
