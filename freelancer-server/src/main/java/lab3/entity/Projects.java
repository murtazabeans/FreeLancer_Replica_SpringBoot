package lab3.entity;

import javax.persistence.*;
import java.util.Date;


@Entity

public class Projects {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "user_id")
    private long userId;

    private String description;

    private String skills_required;

    private Float max_budget;

    private Float min_budget;

    private String assigned_to;

    private Date created_at;

    private String file_name;

    private  Date date_of_completion;

    public Long getId() {
        return id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getDate_of_completion() {
        return date_of_completion;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public String getDescription() {
        return description;
    }

    public String getFile_name() {
        return file_name;
    }

    public Float getMax_budget() {
        return max_budget;
    }

    public Float getMin_budget() {
        return min_budget;
    }

    public String getSkills_required() {
        return skills_required;
    }

    public String getTitle() {
        return title;
    }

    public long getUserId() {
        return userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public void setDate_of_completion(Date date_of_completion) {
        this.date_of_completion = date_of_completion;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setMax_budget(Float max_budget) {
        this.max_budget = max_budget;
    }

    public void setMin_budget(Float min_budget) {
        this.min_budget = min_budget;
    }

    public void setSkills_required(String skills_required) {
        this.skills_required = skills_required;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}

