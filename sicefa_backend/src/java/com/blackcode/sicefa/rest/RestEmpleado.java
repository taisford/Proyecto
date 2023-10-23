
package com.blackcode.sicefa.rest;

import com.blackcode.model.Empleado;
import com.google.gson.Gson;
import come.blackcode.sicefa.core.ControllerEmpleado;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author Esme
 */
@Path("empleado")
public class RestEmpleado {
  
    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        ControllerEmpleado ce= new ControllerEmpleado();
        List<Empleado> empleados = null;
        String out=null;
        Gson gson = new Gson();
        
        try{
            empleados = ce.getAll("");
            out = gson.toJson(empleados);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            out="{\"exception\":" + e.toString().replaceAll("\"", "")+"\"}";
        }
        return Response.ok(out).build();
    }
}
