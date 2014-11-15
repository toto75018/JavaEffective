package com.sunnyobjects.network;
import java.io.*;

/**
 * Exemple simple du contrôle d'un processus externe lancé depuis la JVM.
 * <p>Le <a href="LS.java.html">code source</a>.
 * @author Jean-Baptiste Yunès
 * @date Février 2013
 */
public class LS {
  public static void main(String []args) {
    try {
      Runtime r = Runtime.getRuntime();
      // Launch the external process
      Process p = r.exec("pwd");
      // create an appropriate reader to capture outputs of the process
      BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
      String s = null;
      while ( (s=bf.readLine())!= null ) {
        System.out.println("J'ai lu> "+s);
      }
      // wait for external process termination
      p.waitFor();
      // catch the exit value of the external process
      System.out.println("Valeur de retour "+p.exitValue());
    } catch(Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
