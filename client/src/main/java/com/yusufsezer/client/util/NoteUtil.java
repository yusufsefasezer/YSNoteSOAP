package com.yusufsezer.client.util;

import com.yusufsezer.server.soap.Note;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NoteUtil {

    public static void showNote(Note note) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        String createDate = dtf
                .format(note
                        .getCreated()
                        .toGregorianCalendar()
                        .toZonedDateTime());

        String text = String.format(
                "ID: %s\nNAME: %s\nDESCRIPTION: %s\nCREATE DATE: %s",
                note.getId(),
                note.getName(),
                note.getDescription(),
                createDate);
        System.out.println(text);
    }

    public static Note inputNote(Note note) {
        // Name
        System.out.println("Name");
        String newName = new Scanner(System.in).nextLine();
        note.setName(newName);

        // Description
        System.out.println("Description");
        String newDescription = new Scanner(System.in).nextLine();
        note.setDescription(newDescription);
        return note;
    }
}
