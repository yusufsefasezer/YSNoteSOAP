package com.yusufsezer.server.contract;

import com.yusufsezer.server.model.Note;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface NoteSOAPService {

    @WebMethod
    public void add(@WebParam(name = "entity") Note entity) throws Exception;

    @WebMethod
    public Note get(@WebParam(name = "id") Long primaryKey);

    @WebMethod
    public List<Note> getAll();

    @WebMethod
    public Note update(@WebParam(name = "entity") Note entity) throws Exception;

    @WebMethod
    public void delete(@WebParam(name = "entity") Note entity) throws Exception;

    @WebMethod
    public Long count();

}
