package com.openshift.ff.data;

import javax.persistence.*;

/**
 * Created by spousty on 10/29/14.
 */
@Entity
@Table(name = "many_users_has_many_awards", schema = "public", catalog = "flatfluffy")
@IdClass(ManyUsersHasManyAwardsEntityPK.class)
public class ManyUsersHasManyAwardsEntity {
    private int usersidUsers;
    private int awardsidAwards;
    private AwardsEntity awardsByAwardsidAwards;

    @Id
    @Column(name = "usersid_users")
    public int getUsersidUsers() {
        return usersidUsers;
    }

    public void setUsersidUsers(int usersidUsers) {
        this.usersidUsers = usersidUsers;
    }

    @Id
    @Column(name = "awardsid_awards")
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

        ManyUsersHasManyAwardsEntity that = (ManyUsersHasManyAwardsEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "awardsid_awards", referencedColumnName = "awardsid", nullable = false)
    public AwardsEntity getAwardsByAwardsidAwards() {
        return awardsByAwardsidAwards;
    }

    public void setAwardsByAwardsidAwards(AwardsEntity awardsByAwardsidAwards) {
        this.awardsByAwardsidAwards = awardsByAwardsidAwards;
    }
}
