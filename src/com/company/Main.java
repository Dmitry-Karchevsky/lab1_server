package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345, 1);
            Socket client = serverSocket.accept();
            System.out.println("Сервер запущен");
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());

            while(!client.isClosed()) {
                System.out.println("\nСервер ожидает получения сообщения от клиента");
                String str_from_client = in.readUTF();
                if(str_from_client.equalsIgnoreCase("stop"))
                    break;
                System.out.println("Получена строка для обработки: " + str_from_client);
                Text text = new Text(str_from_client);
                text.Calculate();
                out.writeUTF(text.getResult());
                out.flush();
                System.out.println("Сервер отправил сообщение клиенту");
            }
            System.out.println("Соединение с клиентом разорвано");
            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
