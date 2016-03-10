/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cdi.issues.endpoint.api;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.cdi.issues.endpoint.exception.BusinessException;


/**
 *
 * @author salaboy
 */
@Path("issues")
public interface IssuesService {

    @GET
    @Produces("application/json")
    @Path("")
    public List<String> getAllIssues() throws BusinessException;
    
    
    @POST
    @Produces("application/json")
    @Path("")
    void registerAlert()  throws BusinessException;
    
}
