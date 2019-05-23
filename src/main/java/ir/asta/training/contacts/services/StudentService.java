package ir.asta.training.contacts.services;

/**
 * Created by win_8.1 on 5/18/2019.
 */
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.entities.ContactEntity;
import ir.asta.training.contacts.entities.StudentEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

import java.util.List;

@Path("/student")
public interface StudentService {

    @POST
    @Path("/studentregister")
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<StudentEntity> register(@FormParam("email") String email,
                                                @FormParam("name") String name,
                                                @FormParam("password") String password);


    @POST
    @Path("/addcase")
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<String> AddCase(@FormParam("subject") String subject,
                                        @FormParam("description") String description,
                                        @FormParam("receiver") String receiver,
                                        @FormParam("senderemail") String senderemail,
                                        @FormParam("senderpassword") String senderpassword
                                        );


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getCasesByUserToken/{id}")
    public List<CaseEntity> getCasesByUserToken(@PathParam("id") int token);


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllStudents")
    public List<StudentEntity> findAll();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllCases")
    public List<CaseEntity> getAllCases();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getCaseByCaseToken/{token}")
    public CaseEntity getCaseByCaseToken(@PathParam("token") String token);


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{pk}")
    public ActionResult<String> delete(@PathParam("pk") Long id);


}
