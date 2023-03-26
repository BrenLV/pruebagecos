package services;

import java.util.List;

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
import common.dto.ProductDto;
import model.Category;
import model.Product;



@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductService {
	@EJB
	private ManagerService manager;

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Integer id) throws ToolException {
		return Response.ok(manager.getById(Product.class, id)).build();
	}

	@GET
	public Response getProducts() throws ToolException  {
		List<Object> list = manager.getActives(Product.class);
		return Response.ok(list).build();
	}

	@POST
	public Response create(ProductDto data) throws ToolException {
		Product entity = new Product();
		
		Category category = (Category)manager.getById(Category.class, data.categoryId);
		entity.setCategory(category);
		
		entity.setActive(true);
		entity.setName(data.name);
		entity.setCurrency(data.currency);
		entity.setDescription(data.description);
		entity.setPrice(data.price);
		entity.setStock(data.stock);
		
		manager.create(entity);
		return Response.ok().entity("{\"status\": true}").build();
	}

	@PUT
	public Response update(ProductDto data) throws ToolException {
		Product entity = (Product)manager.getById(Product.class, data.id);
		entity.setName(data.name);
		entity.setCurrency(data.currency);
		entity.setDescription(data.description);
		entity.setPrice(data.price);
		entity.setStock(data.stock);
		
		manager.update(entity);
		return Response.ok().entity("{\"status\": true}").build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) throws ToolException {
		Product entity = (Product)manager.getById(Product.class, id);
		entity.setActive(false);
		manager.update(entity);
		return Response.ok().entity("{\"status\": true}").build();
	}
}
