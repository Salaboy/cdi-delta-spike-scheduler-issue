package org.cdi.issues.endpoint.impl;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import org.cdi.issues.endpoint.api.IssuesService;
import org.cdi.issues.endpoint.exception.BusinessException;


/**
 *
 * @author salaboy
 */
@ApplicationScoped
public class IssuesServiceImpl implements IssuesService {

    private List<String> issues = new ArrayList<>();

    @Context
    SecurityContext context;
    
    @Inject
    private AlertServiceImpl alerts;

    public IssuesServiceImpl() {
        issues.add("example strings");
       
    }

    @Override
    public List<String> getAllIssues() throws BusinessException {
        return issues;
    }
    
    
    public void registerAlert(){
        alerts.registerAlert();
    }

}
