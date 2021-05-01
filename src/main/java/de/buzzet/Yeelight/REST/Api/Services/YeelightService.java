package de.buzzet.Yeelight.REST.Api.Services;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

@Component
public class YeelightService {
    private Socket clientSocket;
    private DataOutputStream outToServer;
    private BufferedReader inFromServer;

    private String sendTCP(String command) {
        String data = "NONE";
        try {
            outToServer.writeBytes("{\"id\":0,\"method\":" + command + "}" + "\r\n");
            data = inFromServer.readLine();
            System.out.println(data);
            //clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void setPower(String status,  int t) {
        sendTCP("\"set_power\",\"params\":[\"" + status + "\", \"sudden\", "+ t + "]");
    }

    public boolean set(String ip, int port) {
        try {
            try {
                if (!clientSocket.isClosed()) {
                    clientSocket.close();
                }
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
            clientSocket = new Socket(ip, port);
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
