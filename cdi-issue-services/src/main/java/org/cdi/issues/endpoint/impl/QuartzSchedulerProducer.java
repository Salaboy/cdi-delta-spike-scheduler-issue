/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toilet.paper.endpoint.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import org.apache.deltaspike.scheduler.spi.Scheduler;
import org.quartz.Job;

/**
 *
 * @author salaboy
 */

public class QuartzSchedulerProducer {
    
    @Produces
    @ApplicationScoped
    protected Scheduler<Job> produceScheduler(Scheduler scheduler)
    {
        return scheduler;
    }
}
