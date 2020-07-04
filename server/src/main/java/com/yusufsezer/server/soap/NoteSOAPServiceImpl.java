package com.yusufsezer.server.soap;

import com.yusufsezer.server.contract.NoteSOAPService;
import com.yusufsezer.server.model.Note;
import com.yusufsezer.server.util.JPAUtil;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class NoteSOAPServiceImpl implements NoteSOAPService {

    @Override
    public void add(@WebParam(name = "entity") Note entity) throws Exception {
        JPAUtil.getNoteService().create(entity);
    }

    @Override
    public Note get(@WebParam(name = "id") Long primaryKey) {
        return JPAUtil.getNoteService().find(primaryKey);
    }

    @Override
    public List<Note> getAll() {
        return JPAUtil.getNoteService().findAll();
    }

    @Override
    public Note update(@WebParam(name = "entity") Note entity) throws Exception {
        JPAUtil.getNoteService().edit(entity);
        return JPAUtil.getNoteService().find(entity.getId());
    }

    @Override
    public void delete(@WebParam(name = "entity") Note entity) throws Exception {
        JPAUtil.getNoteService().remove(entity);
    }

    @Override
    public Long count() {
        return JPAUtil.getNoteService().count();
    }

}
