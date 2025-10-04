package webservices;
import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")
public class UEResources {
    UniteEnseignementBusiness helper = new UniteEnseignementBusiness();
    @Path("/liste")
    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public  Response liste()
    {
        return Response.status(200).entity(
                helper.getListeUE()
        ).build();
    }
    @Path("/ajout")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response ajout(UniteEnseignement ue)
    {
        if (helper.addUniteEnseignement(ue))
        {
            return  Response.status(201).entity("added succesfully").build();
        }else { return  Response.status(409).entity("already exist").build();
    }

}
    @Path("/delete/{id}")
    @DELETE @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") int id)
    { if (helper.deleteUniteEnseignement(id))
    { return Response.status(200).entity("deleted successfully").build(); }
    else { return Response.status(404).entity("not found").build(); }
}
}
