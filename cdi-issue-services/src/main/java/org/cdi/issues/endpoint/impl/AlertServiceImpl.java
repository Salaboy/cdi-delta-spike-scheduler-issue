/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cdi.issues.endpoint.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import org.apache.deltaspike.scheduler.api.Scheduled;
import org.apache.deltaspike.scheduler.spi.Scheduler;
import org.cdi.issues.endpoint.api.IssuesService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author salaboy
 */
@ApplicationScoped
public class AlertServiceImpl {

    @Inject
    private Scheduler<Job> jobScheduler;
    
    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        registerAlert();
    }

    public AlertServiceImpl() {
    }

    public Scheduler<Job> getJobScheduler() {
        return jobScheduler;
    }

    public void setJobScheduler(Scheduler<Job> jobScheduler) {
        this.jobScheduler = jobScheduler;
    }

    public void registerAlert() {
        System.out.println(">>> Registering Alert ");
        jobScheduler.registerNewJob(AlertJobImpl.class);
    }

    @Scheduled(cronExpression = "* * * * * ?", onStartup = true)
    @ApplicationScoped
    public static class AlertJobImpl implements org.quartz.Job {

        @Inject
        private IssuesService service;
        
        @Override
        public void execute(JobExecutionContext jec) throws JobExecutionException {
            System.out.println(">>> Job Executed! -> "+service);
        }

    }

}
