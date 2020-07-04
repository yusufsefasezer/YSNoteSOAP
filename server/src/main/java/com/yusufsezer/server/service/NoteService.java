package com.yusufsezer.server.service;

import com.yusufsezer.server.contract.AbstractService;
import com.yusufsezer.server.model.Note;
import javax.persistence.EntityManager;

public class NoteService extends AbstractService<Note> {

    public NoteService(EntityManager entityManager) {
        super(Note.class);
        setEntityManager(entityManager);
    }

}
