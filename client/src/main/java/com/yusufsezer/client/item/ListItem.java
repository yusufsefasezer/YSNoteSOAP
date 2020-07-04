package com.yusufsezer.client.item;

import com.yusufsezer.client.contract.Item;
import com.yusufsezer.client.util.NoteUtil;
import com.yusufsezer.client.util.ServiceUtil;
import com.yusufsezer.server.soap.Note;
import java.util.List;

public class ListItem implements Item {

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public String getTitle() {
        return "List all notes";
    }

    @Override
    public void run() {
        List<Note> notes = ServiceUtil
                .getService()
                .getAll();
        notes.forEach((note) -> {
            NoteUtil.showNote(note);
        });
    }

}
