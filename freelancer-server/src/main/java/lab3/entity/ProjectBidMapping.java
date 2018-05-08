package lab3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity

public class ProjectBidMapping {

    @Id
    private Long id;

    private String title;

    private long userId;

    private String name;

    private String description;

    private String skills_required;

    private String max_budget;

    private String min_budget;

    private String assigned_to;

    private Date created_at;

    private String file_name;

    private  Date date_of_completion;

    private Long days;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public Date getDate_of_completion() {
        return date_of_completion;
    }

    public String getDescription() {
        return description;
    }

    public String getFile_name() {
        return file_name;
    }

    public String getMax_budget() {
        return max_budget;
    }

    public String getMin_budget() {
        return min_budget;
    }

    public String getSkills_required() {
        return skills_required;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public long getUserId() {
        return userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate_of_completion(Date date_of_completion) {
        this.date_of_completion = date_of_completion;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setMax_budget(String max_budget) {
        this.max_budget = max_budget;
    }

    public void setMin_budget(String min_budget) {
        this.min_budget = min_budget;
    }

    public void setSkills_required(String skills_required) {
        this.skills_required = skills_required;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Long getDays() {
        return days;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    //
//    private String title;
//
//    private  long employer_id;
//
////    private String free_lancer_name;
//
//    private String assigned_to;
//    private  Date date_of_completion;
//    private String owner;
//
////    private long my_bid;
//
//    private long avg_days;
//
//    private long bid_id;
//
////    public long getMy_bid() {
////        return my_bid;
////    }
//
//    public long getBid_id() {
//        return bid_id;
//    }
//
//    public void setBid_id(long bid_id) {
//        this.bid_id = bid_id;
//    }
//
////    public void setMy_bid(long my_bid) {
////        this.my_bid = my_bid;
////    }
//
//    //    public String getFree_lancer_name() {
////        return free_lancer_name;
////    }
////
////    public void setFree_lancer_name(String free_lancer_name) {
////        this.free_lancer_name = free_lancer_name;
////    }
//
//    public long getAvg_days() {
//        return avg_days;
//    }
//
//    public void setAvg_days(long avg_days) {
//        this.avg_days = avg_days;
//    }
//
//
//
////    public String getFreeLancer() {
////        return freeLancer;
////    }
//
////    public long getAvgDays() {
////        return avgDays;
////    }
//
//    public long getEmployer_id() {
//        return employer_id;
//    }
//
////    public long getNumber_of_days() {
////        return number_of_days;
////    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public Date getDate_of_completion() {
//        return date_of_completion;
//    }
//
//    public String getAssigned_to() {
//        return assigned_to;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
////    public String getFreelancer_name() {
////        return freelancer_name;
////    }
//
//    public String getOwner() {
//        return owner;
//    }
//
////    public void setFreeLancer(String freeLancer) {
////        this.freeLancer = freeLancer;
////    }
//
////    public void setAvgDays(long avgDays) {
////        this.avgDays = avgDays;
////    }
//
//    public void setEmployer_id(long employer_id) {
//        this.employer_id = employer_id;
//    }
//
//    public void setAssigned_to(String assigned_to) {
//        this.assigned_to = assigned_to;
//    }
//
//    public void setDate_of_completion(Date date_of_completion) {
//        this.date_of_completion = date_of_completion;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setOwner(String owner) {
//        this.owner = owner;
//    }


}
