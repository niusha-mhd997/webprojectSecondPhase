package ir.asta.training.contacts.services;

import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.entities.ContactEntity;
import ir.asta.training.contacts.entities.EmployeeEntity;
import ir.asta.training.contacts.entities.StudentEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

import java.util.List;

@Path("/manager")
public interface ManagerService {

    @POST
    @Path("/acceptemployee")
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<String> AcceptEmployee(@FormParam("employeemail") String employeemail);


    @GET
    @Path("/getnotacceptedemps")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeEntity> getAllNotPermittedEmployees();

    @GET
    @Path("/getnacceptedemps")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeEntity> getAllPermittedEmployees();

}
