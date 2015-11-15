package org.thinkadv.d2dzone.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
@Path("hello")
public class HelloWorld {
 
  @GET
  @Produces("application/javascript") 
  @Path("/{param}")
  public Response getMsg(@PathParam("param") String msg,@QueryParam("callback") String callback) {
    
    String output = "{\"msg\":\"welcome " + msg + " to the world of JQuery and Rest\"}";
 
//    String output = "mycallback({\"msg\":\"welcome " + msg + " to the world of JQuery and Rest\"})";
    output = callback + "("+ output + ");";
 
    return Response.status(200).entity(output).build();
 
  }
  
  @GET
  @Produces("application/javascript") 
  @Path("/get/{param}")
  public Response getMessage(@PathParam("param") String msg) {
    
    String output = "{\"get msg\":\"welcome " + msg + " to the world of JQuery and Rest\"}";
 
//    String output = "mycallback({\"msg\":\"welcome " + msg + " to the world of JQuery and Rest\"})";
//    output = callback + "("+ output + ");";
 
    return Response.status(200).entity(output).build();
 
  }
  
  @POST
  @Produces("application/javascript") 
  @Path("/post")
  public Response postMessage(String msg) {
    
    String output = "{\"post msg\":\"welcome " + msg + " to the world of JQuery and Rest\"}";
 
//    String output = "mycallback({\"msg\":\"welcome " + msg + " to the world of JQuery and Rest\"})";
//    output = callback + "("+ output + ");";
 
    return Response.status(200).entity(output).build();
 
  }
  
  @POST
  @Produces("application/javascript") 
  @Path("/post/data")
  public Response postData(String msg) {
    
    String output = "{\"post msg\":\"welcome " + msg + " to the world of JQuery and Rest\"}";
 
//    String output = "mycallback({\"msg\":\"welcome " + msg + " to the world of JQuery and Rest\"})";
//    output = callback + "("+ output + ");";
 
    return Response.status(200).entity(output).build();
 
  }
}