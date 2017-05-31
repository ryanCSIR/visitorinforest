package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import model.EmployeeLocation;
import model.EmployeePushid;

import org.glassfish.jersey.server.JSONP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.EmployeeLocationDAOImpl;
import dao.EmployeePushidDAOImpl;

@Path("/visinfo")
@Component
public class Resource {
	@Autowired
	private EmployeeLocationDAOImpl empLocDAO;
	@Autowired
	private EmployeePushidDAOImpl empPushDAO;

	@Context
	UriInfo uriInfo;

	@GET
	@Path("/employees")
	@SuppressWarnings("rawtypes")
	@JSONP(queryParam = "callback")
	@Produces({ "application/x-javascript" })
	public Response findEmployee(@QueryParam("name") String name,
			@QueryParam("callback") String callback) throws Exception {
		List<EmployeeLocation> loc = null;
		GenericEntity generic = null;

		try {
			loc = empLocDAO.findByCriteria("name", name);
			generic = new GenericEntity<List<EmployeeLocation>>(loc) {
			};
		} catch (Exception e) {
			throw e;
		}
		return Response.status(Response.Status.OK).entity(generic).build();
	}

	@GET
	@Path("/findpushid")
	@SuppressWarnings("rawtypes")
	@JSONP(queryParam = "callback")
	@Produces({ "application/x-javascript" })
	public Response findPushId(@QueryParam("lan_id") String id,
			@QueryParam("callback") String callback) throws Exception {
		List<EmployeePushid> empPushid = null;
		GenericEntity generic = null;

		try {
			empPushid = empPushDAO.findByCriteria("lanUserId", id);
			generic = new GenericEntity<List<EmployeePushid>>(empPushid) {
			};
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}

		return Response.status(200).entity(generic).build();
	}

	@Path("/createpushid")
	@GET
	@JSONP(queryParam = "callback")
	@Produces({ "application/x-javascript" })
	public Response createPushId(@QueryParam("lan_id") String id,
			@QueryParam("push_id") String pushid,
			@QueryParam("callback") String callback) throws Exception {
		EmployeePushid empPushid = null;

		try {
			empPushid = new EmployeePushid();
			empPushid.setLanUserId(id);
			empPushid.setPushId(pushid);

			if (empPushDAO.findByCriteria("lanUserId", id).size() == 0) {
				empPushDAO.save(empPushid);
			} else {
				empPushDAO.update(empPushid);
			}
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}

		return Response.status(200).build();
	}

}
