package com.openshift.ff.ws;
import com.openshift.ff.data.AwardsEntity;
import com.openshift.ff.data.ManyUsersHasManyAwardsEntity;
import com.openshift.ff.data.User;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;

/**
 * Created by spousty on 10/30/14.
 */
@RequestScoped
@Stateless
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
        //Get the id for the WElcome award
        AwardsEntity welcomeAward = em.createQuery("select a from AwardsEntity a where a.awardname = 'Welcome'", AwardsEntity.class).getSingleResult();
        Integer awardid = welcomeAward.getAwardsid();


        ManyUsersHasManyAwardsEntity awardUser = new ManyUsersHasManyAwardsEntity();
        awardUser.setAwardsidAwards(awardid);
        awardUser.setUsersidUsers(userid);
        em.persist(awardUser);

        return awardUser;

    }

    @GET
    @Produces("application/json")
    public List usersAwards(){
        List rewards = new ArrayList();
        rewards = em.createQuery("select m from ManyUsersHasManyAwardsEntity m").getResultList();
        return rewards;
    }


}
