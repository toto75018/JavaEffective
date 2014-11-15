package com.sunnyobjects.network;
import java.net.*;

/**
 * Un r�cepteur UDP. Les messages re�us sont des <code>String</code>.
 * Pour chae message re�u, un num�ro d'ordre est attribu�, le message est
 * affich� avec son num�ro d'ordre et l'adresse de l'exp�diteur aussi.
 * Le <a href="Recepteur.java.html">code source</a>.
 * @author Jean-Baptiste Yun�s
 * @date F�vrier 2013
 */
public class Recepteur {
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
        System.out.println("From adresse: "+paquet.getAddress() + "- port :" + paquet.getPort());
      }
    } catch(Exception ex) {
      ex.printStackTrace();
      System.exit(1);
    }
  }
}
