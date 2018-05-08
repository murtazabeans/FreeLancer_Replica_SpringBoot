package lab3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity

public class ProjectUserBidMapping {

    @Id
    private Long id;

    private String title;

    private  long employer_id;

    private String assigned_to;
    private  Date date_of_completion;
    private String owner;

    String freelancer_name;

    private long avg_days;

    private long bid_id;

    private long bid_price;

    private String profile_image_name;

    public long getBid_price() {
        return bid_price;
    }

    public void setBid_price(long bid_price) {
        this.bid_price = bid_price;
    }

    public void setProfile_image_name(String profile_image_name) {
        this.profile_image_name = profile_image_name;
    }

    public String getProfile_image_name() {
        return profile_image_name;
    }

    public long getBid_id() {
        return bid_id;
    }

    public void setBid_id(long bid_id) {
        this.bid_id = bid_id;
    }

    public String getFreelancer_name() {
        return freelancer_name;
    }

    public void setFreelancer_name(String freelancer_name) {
        this.freelancer_name = freelancer_name;
    }


    public long getAvg_days() {
        return avg_days;
    }

    public void setAvg_days(long avg_days) {
        this.avg_days = avg_days;
    }

    public long getEmployer_id() {
        return employer_id;
    }

    public Long getId() {
        return id;
    }

    public Date getDate_of_completion() {
        return date_of_completion;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public String getTitle() {
        return title;
    }

//    public String getFreelancer_name() {
//        return freelancer_name;
//    }

    public String getOwner() {
        return owner;
    }

//    public void setFreeLancer(String freeLancer) {
//        this.freeLancer = freeLancer;
//    }

//    public void setAvgDays(long avgDays) {
//        this.avgDays = avgDays;
//    }

    public void setEmployer_id(long employer_id) {
        this.employer_id = employer_id;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public void setDate_of_completion(Date date_of_completion) {
        this.date_of_completion = date_of_completion;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public void setNumber_of_days(long number_of_days) {
//        this.number_of_days = number_of_days;
//    }

//    public void setFreelancer_name(String freelancer_name) {
//        this.freelancer_name = freelancer_name;
//    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    //    @Column(name = "user_id")
//    private long projectUserId;

//    private String description;
//
//    private String skills_required;
//
//    private String max_budget;
//
//    private String min_budget;
//

//
//    private String file_name;
//
//    private  Date date_of_completion;
//
////    @Column(name = "user_id")
////    private long bidUserId;
//
//    private long number_of_days;
//
//    private float price;
//    private String status;
//
//
//    private String name;
//
//    private String email;
//
//    private String password;
//
//    private String phone_number;
//
//    private String aboutMe;
//
//    private String profile_image_name;
//
//    private String skills;
//
//    private  String owner;
//
//
//    public String getStatus() {
//        return status;
//    }
//
//    public float getPrice() {
//        return price;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getSkills_required() {
//        return skills_required;
//    }
//
//    public String getMin_budget() {
//        return min_budget;
//    }
//
//    public String getMax_budget() {
//        return max_budget;
//    }
//
//    public String getFile_name() {
//        return file_name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getAssigned_to() {
//        return assigned_to;
//    }
//
//    public Date getDate_of_completion() {
//        return date_of_completion;
//    }
//
//    public String getAbout_me() {
//        return aboutMe;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getPhone_number() {
//        return phone_number;
//    }
//
//    public String getProfile_image_name() {
//        return profile_image_name;
//    }
//
//    public String getSkills() {
//        return skills;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
////    public long getBidUserId() {
////        return bidUserId;
////    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public long getNumber_of_days() {
//        return number_of_days;
//    }
//
//    public long getprojectId() {
//        return projectId;
//    }
//
////    public long getProjectUserId() {
////        return projectUserId;
////    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public void setPrice(float price) {
//        this.price = price;
//    }
//
//    public void setNumber_of_days(long number_of_days) {
//        this.number_of_days = number_of_days;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setSkills_required(String skills_required) {
//        this.skills_required = skills_required;
//    }
//
//    public void setMin_budget(String min_budget) {
//        this.min_budget = min_budget;
//    }
//
//    public void setMax_budget(String max_budget) {
//        this.max_budget = max_budget;
//    }
//
//    public void setFile_name(String file_name) {
//        this.file_name = file_name;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setDate_of_completion(Date date_of_completion) {
//        this.date_of_completion = date_of_completion;
//    }
//
//    public void setAssigned_to(String assigned_to) {
//        this.assigned_to = assigned_to;
//    }
//
//    public void setAbout_me(String aboutMe) {
//        this.aboutMe = aboutMe;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setPhone_number(String phone_number) {
//        this.phone_number = phone_number;
//    }
//
//    public void setSkills(String skills) {
//        this.skills = skills;
//    }
//
//    public void setProfile_image_name(String profile_image_name) {
//        this.profile_image_name = profile_image_name;
//    }
//
////    public void setBidUserId(long bidUserId) {
////        this.bidUserId = bidUserId;
////    }
//
//    public void setProjectId(long projectId) {
//        this.projectId = projectId;

//
////    public void setProjectUserId(long projectUserId) {
////        this.projectUserId = projectUserId;
////    }
//
//    public long getEmployer_id() {
//        return employer_id;
//    }
//
//    public void setEmployer_id(long employer_id) {
//        this.employer_id = employer_id;
//    }
//
//    public long getAvgDays() {
//        return avgDays;
//    }
//
//    public void setAvgDays(long avgDays) {
//        this.avgDays = avgDays;
//    }
//
//    public String getFreeLancer() {
//        return freeLancer;
//    }
//
//    public void setFreeLancer(String freeLancer) {
//        this.freeLancer = freeLancer;
//    }
}
