package com.yusufsezer.client.item;

import com.yusufsezer.client.contract.Item;
import com.yusufsezer.client.util.NoteUtil;
import com.yusufsezer.client.util.ServiceUtil;
import com.yusufsezer.server.soap.Exception_Exception;
import com.yusufsezer.server.soap.Note;
import com.yusufsezer.server.soap.NoteSOAPServiceImpl;
import java.util.Scanner;

public class EditItem implements Item {

    @Override
    public String getName() {
        return "edit";
    }

    @Override
    public String getTitle() {
        return "Edit note";
    }

    @Override
    public void run() {
        System.out.println("Please Enter Note ID");
        Long noteId = new Scanner(System.in).nextLong();
        NoteSOAPServiceImpl service = ServiceUtil.getService();
        try {
            Note foundNote = service.get(noteId);
            if (foundNote != null) {
                foundNote = NoteUtil.inputNote(foundNote);
                service.update(foundNote);
                System.out.println("Note updated successfully");
            } else {
                System.out.println("Please enter valid ID");
            }
        } catch (Exception_Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
