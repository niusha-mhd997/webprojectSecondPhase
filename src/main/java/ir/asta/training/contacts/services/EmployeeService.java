package ir.asta.training.contacts.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ir.asta.training.contacts.entities.*;
import ir.asta.wise.core.datamanagement.ActionResult;
import java.util.List;

/**
 * Created by win_8.1 on 6/13/2019.
 */

@Path("/employee")
public interface EmployeeService {

    @GET
    @Path("/getallemployees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeEntity> getAllEmployees();


    @POST
    @Path("/employeeregister")
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<EmployeeEntity> register(@FormParam("email") String email,
                                                @FormParam("name") String name,
                                                @FormParam("semat") String semat,
                                                @FormParam("password") String password);


    @GET
    @Path("/getEmployeeCasesByToken/{token}/{done}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CaseEntity> getEmployeeCasesByToken(@PathParam("token") int token,
                                                            @PathParam("done") boolean done
    );
}
