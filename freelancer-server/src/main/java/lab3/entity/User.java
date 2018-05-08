package lab3.entity;

import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class

public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String phone_number;

    private String about_me;

    private String profile_image_name;

    private String skills;

    private Date created_at;

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setProfile_image_name(String profile_image_name) {
        this.profile_image_name = profile_image_name;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setAbout_me(String about_me) {
        this.about_me = about_me;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getSkills() {
        return skills;
    }

    public String getProfile_image_name() {
        return profile_image_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAbout_me() {
        return about_me;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Long getId() {
        return id;
    }
}