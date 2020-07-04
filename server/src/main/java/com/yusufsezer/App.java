package com.yusufsezer;

import com.yusufsezer.server.soap.NoteSOAPServiceImpl;
import javax.xml.ws.Endpoint;

public class App {

    private static final String WEB_SERVICE_URL = "http://localhost:8080/YSNoteWS";

    public static void main(String[] args) {
        Endpoint.publish(WEB_SERVICE_URL, new NoteSOAPServiceImpl());
        System.out.println("SOAP Web Service is started.");
        System.out.println("Address: " + WEB_SERVICE_URL);
    }

}
