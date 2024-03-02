package com.yusufsezer.server.util;

import com.yusufsezer.server.service.NoteService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JPAUtil {

    private static final String PERSISTENCE_UNIT_NAME = "YSPersistenceUnit";
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static NoteService service;

    static {
        try {
            emf = Persistence
                    .createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Throwable ex) {
            Logger
                    .getLogger(JPAUtil.class.getName())
                    .log(Level.SEVERE, null, ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }

    public static NoteService getNoteService() {
        if (service == null) {
            service = new NoteService(getEntityManager());
        }
        return service;
    }

}
