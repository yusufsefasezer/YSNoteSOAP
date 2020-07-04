package com.yusufsezer.client.util;

import com.yusufsezer.server.soap.NoteSOAPServiceImpl;
import com.yusufsezer.server.soap.NoteSOAPServiceImplService;

public class ServiceUtil {

    private static NoteSOAPServiceImplService service;

    public static NoteSOAPServiceImpl getService() {
        if (service == null) {
            service = new NoteSOAPServiceImplService();
        }
        return service.getNoteSOAPServiceImplPort();
    }

}
