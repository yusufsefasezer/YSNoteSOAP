package com.yusufsezer.client.item;

import com.yusufsezer.client.contract.Item;
import com.yusufsezer.client.util.NoteUtil;
import com.yusufsezer.client.util.ServiceUtil;
import com.yusufsezer.server.soap.Note;
import com.yusufsezer.server.soap.NoteSOAPServiceImpl;
import java.util.Scanner;

public class GetByIdItem implements Item {

    @Override
    public String getName() {
        return "getById";
    }

    @Override
    public String getTitle() {
        return "Get Note By Id";
    }

    @Override
    public void run() {
        System.out.println("Please Enter Note ID");
        Long noteId = new Scanner(System.in).nextLong();
        Note foundNote = ServiceUtil
                .getService()
                .get(noteId);
        if (foundNote != null) {
            NoteUtil.showNote(foundNote);
        } else {
            System.out.println("Please enter valid ID");
        }
    }

}
