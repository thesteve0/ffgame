package com.openshift.ff.data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by spousty on 10/29/14.
 */
@Entity
@Table(name = "awards", schema = "public", catalog = "flatfluffy")
@NamedQuery(name = "Awards.findByAwardName", query = "select a from AwardsEntity a where a.awardname = :name")
public class AwardsEntity {
    private int awardsid;
    private String awardname;
    private String description;
    private String notes;
    private Timestamp entrytimestamp;

    @PrePersist
    protected void onCreate() {
        entrytimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    @Id
    @Column(name = "awardsid", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "awards_awardsid_seq")
    @SequenceGenerator(name =  "awards_awardsid_seq", sequenceName =  "awards_awardsid_seq", allocationSize = 1)
    public int getAwardsid() {
        return awardsid;
    }

    public void setAwardsid(int awardsid) {
        this.awardsid = awardsid;
    }

    @Basic
    @Column(name = "awardname")
    public String getAwardname() {
        return awardname;
    }

    public void setAwardname(String awardname) {
        this.awardname = awardname;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "entrytimestamp")
    public Timestamp getEntrytimestamp() {
        return entrytimestamp;
    }

    public void setEntrytimestamp(Timestamp entrytimestamp) {
        this.entrytimestamp = entrytimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AwardsEntity that = (AwardsEntity) o;

        if (awardsid != that.awardsid) return false;
        if (awardname != null ? !awardname.equals(that.awardname) : that.awardname != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (entrytimestamp != null ? !entrytimestamp.equals(that.entrytimestamp) : that.entrytimestamp != null)
            return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = awardsid;
        result = 31 * result + (awardname != null ? awardname.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (entrytimestamp != null ? entrytimestamp.hashCode() : 0);
        return result;
    }
}
