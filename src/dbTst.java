package com.jmarques;

import javax.swing.*;
import java.io.*;

public class dbTst {
    static String url;

    public static void main(String[] args) {
        System.out.println("JUST TESTING MY FRIENDS");
    }


    public static void setPathConnection(){
        String pathConnection="";
        try (FileReader fr = new FileReader(new File("C:\\TheFactory_Clubhouse_SMS\\Configs\\urlConnection.txt"));
             BufferedReader br = new BufferedReader(fr);) {
            int ch;
            while ((ch = br.read()) != -1) {
                pathConnection += ""+Character.toString(ch);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Missing file");
            JFrame frame = new JFrame();
            System.exit(0);
        } catch (IOException e) {
            JFrame frame = new JFrame();
            System.exit(0);
        }
        url = pathConnection;
    }


}
