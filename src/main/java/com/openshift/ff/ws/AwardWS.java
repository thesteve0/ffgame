package com.openshift.ff.ws;

import com.openshift.ff.data.AwardsEntity;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spousty on 10/29/14.
 */

@RequestScoped
@Stateless
@Path("/")
public class AwardWS {


    @PersistenceContext(name = "kills")
    EntityManager em;

    @GET
    @Produces("application/json")
    public List getAwardTypes(){
        ArrayList<AwardsEntity> awardTypes = new ArrayList<AwardsEntity>();

        Query query = em.createQuery("select a from AwardsEntity a");

        awardTypes = (ArrayList<AwardsEntity>) query.getResultList();

        return awardTypes;

    }

}
