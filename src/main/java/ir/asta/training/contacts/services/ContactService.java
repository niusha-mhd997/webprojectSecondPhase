package ir.asta.training.contacts.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ir.asta.training.contacts.entities.ContactEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

import java.util.List;

@Path("/contact")
public interface ContactService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/load/{pk}")
	public ContactEntity load(@PathParam("pk") Long id);

	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ActionResult<Long> save(ContactEntity entity);


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getContacts/{entityname}")
	public List<ContactEntity> findAll(@PathParam("entityname") String entityName);


	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public ActionResult<Object> Login(@FormParam("email") String email,
									  @FormParam("password") String password);

}
