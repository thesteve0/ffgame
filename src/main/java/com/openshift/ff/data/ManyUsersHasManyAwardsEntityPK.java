package com.openshift.ff.data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by spousty on 10/29/14.
 */
public class ManyUsersHasManyAwardsEntityPK implements Serializable {
    private int usersidUsers;
    private int awardsidAwards;

    @Column(name = "usersid_users")
    @Id
    public int getUsersidUsers() {
        return usersidUsers;
    }

    public void setUsersidUsers(int usersidUsers) {
        this.usersidUsers = usersidUsers;
    }

    @Column(name = "awardsid_awards")
    @Id
    public int getAwardsidAwards() {
        return awardsidAwards;
    }

    public void setAwardsidAwards(int awardsidAwards) {
        this.awardsidAwards = awardsidAwards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManyUsersHasManyAwardsEntityPK that = (ManyUsersHasManyAwardsEntityPK) o;

        if (awardsidAwards != that.awardsidAwards) return false;
        if (usersidUsers != that.usersidUsers) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = usersidUsers;
        result = 31 * result + awardsidAwards;
        return result;
    }
}
