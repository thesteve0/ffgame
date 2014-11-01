package com.openshift.ff.ws;
import com.openshift.ff.data.AwardsEntity;
import com.openshift.ff.data.ManyUsersHasManyAwardsEntity;
import com.openshift.ff.data.User;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;

/**
 * Created by spousty on 10/30/14.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/reward")
public class RewardWS {

    @PersistenceContext(name = "awards")
    EntityManager em;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/newuser")
    public ManyUsersHasManyAwardsEntity giveNewUserReward(User user) {
        // Return some cliched textual content
        Integer userid = user.getUsersid();
        System.out.println(userid);
        /*
        Query query = em.createQuery("select a.awardsid from AwardsEntity a where a.awardname = :name", AwardsEntity.class);
        query.setParameter("name", "Welcome");
        Integer awardid = (Integer) query.getSingleResult();
        */
        ManyUsersHasManyAwardsEntity awardUser = new ManyUsersHasManyAwardsEntity();

        /*
        awardUser.setAwardsidAwards(awardid);
        awardUser.setUsersidUsers(userid);
        em.persist(awardUser);
        */
        return awardUser;

    }

    @GET
    @Produces("application/json")
    public List usersAwards(){
        ArrayList rewards = new ArrayList();
        //TODO fill in later
        return rewards;
    }


}
