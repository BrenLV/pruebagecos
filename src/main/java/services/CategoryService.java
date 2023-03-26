package services;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ManagerService;
import common.ToolException;
import common.dto.CategoryDto;
import model.Category;

import java.util.List;


@Path("/categories")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoryService {
	@EJB
	private ManagerService manager;

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Integer id) throws ToolException {
		return Response.ok(manager.getById(Category.class, id)).build();
	}

	@GET
	public Response getCategories() throws ToolException {
		List<Object> list = manager.getAll(Category.class);
		return Response.ok(list).build();
	}

	@POST
	public Response create(CategoryDto data) throws ToolException {
		Category entity = new Category();
		entity.setName(data.name);
		entity.setVersion(data.version);
		manager.create(entity);
		return Response.ok().entity("{\"status\": true}").build();
	}

	@PUT
	public Response update(CategoryDto data) throws ToolException {
		Category entity = (Category)manager.getById(Category.class, data.id);
		entity.setName(data.name);
		entity.setVersion(data.version);
		manager.update(entity);
		return Response.ok().entity("{\"status\": true}").build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) throws ToolException {
		Category entity = (Category)manager.getById(Category.class, id);
		manager.remove(entity);
		return Response.ok().entity("{\"status\": true}").build();
	}
}
