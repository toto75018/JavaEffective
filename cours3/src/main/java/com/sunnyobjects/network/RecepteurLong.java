package com.sunnyobjects.network;
import java.net.*;

/**
 * Un récepteur UDP. Les messages reçus sont des <code>String</code>.
 * Pour chae message reçu, un numéro d'ordre est attribué, le message est
 * affiché avec son numéro d'ordre et l'adresse de l'expéditeur aussi.
 * Après chaque message reçu, le récepteur s'endort environ 50ms.
 * Le <a href="RecepteurLong.java.html">code source</a>.
 * @author Jean-Baptiste Yunès
 * @date Février 2013
 */
public class RecepteurLong {
  public static void main(String []args) {
    try {
      int n=0;
      DatagramSocket s = new DatagramSocket(55678);
      byte [] data = new byte[100];
      DatagramPacket paquet = new DatagramPacket(data,data.length);
      while (true) {
        s.receive(paquet); n++;
        String st = new String(paquet.getData(),0,paquet.getLength());
        System.out.println("Received ["+st+"] "+n);
        System.out.println("From: "+paquet.getAddress());
        try {
          Thread.sleep(50);
        } catch(Exception e) {}
      }
    } catch(Exception ex) {
      ex.printStackTrace();
      System.exit(1);
    }
  }
}
