package lab3.entity;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;


    @Column(name = "project_id")
    private long projectId;

    @Column(name = "user_id")
    private long userId;

    private long number_of_days;
    private Date created_at;
    private float price;
    private String status;

    public Date getCreated_at() {
        return created_at;
    }

    public float getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserIdd() {
        return userId;
    }

    public long getNumber_of_days() {
        return number_of_days;
    }

    public String getStatus() {
        return status;
    }

    public void setUser_id(long userId) {
        this.userId = userId;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumber_of_days(long number_of_days) {
        this.number_of_days = number_of_days;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
