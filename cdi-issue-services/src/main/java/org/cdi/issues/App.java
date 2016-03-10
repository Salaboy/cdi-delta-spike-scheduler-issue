/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cdi.issues;





import org.cdi.issues.endpoint.api.IssuesService;
import org.cdi.issues.endpoint.exception.BusinessException;
import org.cdi.issues.endpoint.exception.HttpStatusExceptionHandler;
import org.cdi.issues.endpoint.impl.IssuesServiceImpl;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.toilet.paper.endpoint.config.AuthRESTResponseFilter;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.keycloak.Secured;

/**
 *
 * @author salaboy
 */
public class App {

    public static void main(String[] args) throws Exception {
        Container container = new Container();

        container.start();

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
        deployment.as(Secured.class);
        deployment.setContextRoot("/api");
        deployment.addPackages(true, "org.cdi.issues.endpoint");
        deployment.addPackages(true, "org.quartz");
        deployment.addResource(IssuesService.class);
        deployment.addResource(IssuesServiceImpl.class);
        deployment.addClass(HttpStatusExceptionHandler.class);
        deployment.addClass(BusinessException.class);
        deployment.addClass(AuthRESTResponseFilter.class);
        deployment.addAllDependencies();
        container.deploy(deployment);
    }
}
