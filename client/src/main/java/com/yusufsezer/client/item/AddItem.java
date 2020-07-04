package com.yusufsezer.client.item;

import com.yusufsezer.client.contract.Item;
import com.yusufsezer.client.util.NoteUtil;
import com.yusufsezer.client.util.ServiceUtil;
import com.yusufsezer.server.soap.Exception_Exception;
import com.yusufsezer.server.soap.Note;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddItem implements Item {

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getTitle() {
        return "Add new note";
    }

    @Override
    public void run() {
        Note newNote = NoteUtil.inputNote(new Note());
        try {
            ServiceUtil
                    .getService()
                    .add(newNote);
            System.out.println("Note added successfully");
        } catch (Exception_Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
