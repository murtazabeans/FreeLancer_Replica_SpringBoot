package lab3.controller;


import lab3.entity.ProjectBidMapping;
import lab3.entity.ProjectUserBidMapping;
import lab3.entity.Projects;
import lab3.entity.User;
import lab3.services.ProjectService;
import lab3.services.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

@Controller
@RequestMapping(path="/project")
public class ProjectController{
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getallprojects", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Projects> getallprojects() {

        Map<String, Object> result = new HashMap();
        List<ProjectBidMapping> projects;
        projects = projectService.findAllProjects();
        result.put("rows", projects);
        return new ResponseEntity(result, HttpStatus.OK);

    }

    @PostMapping(value = "/get_project_detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Projects> get_project_detail(@RequestBody String project_id) {

          System.out.println("I am project " + project_id);


          JSONObject jsonObject = new JSONObject(project_id);

          List<ProjectBidMapping> project = projectService.getProjectDetail(jsonObject.getLong("project_id"));

          Map<String, Object> result = new HashMap();

          result.put("rows", project);

        return new ResponseEntity(result, HttpStatus.OK);

    }

    @PostMapping(value = "/get_all_user_published_projects", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Projects> get_all_user_published_projects(@RequestBody String user_id) {
        JSONObject jsonObject = new JSONObject(user_id);
        List<ProjectUserBidMapping> project = projectService.getUserPublishedProjects(jsonObject.getLong("user_id"));
        Map<String, Object> result = new HashMap();
        Iterable<User> users = userService.findAllUsers();
        result.put("rows", project);
        result.put("users", users);
        System.out.println("This is project" + project);
        return new ResponseEntity(result, HttpStatus.OK);

    }

    @PostMapping(value = "/get_all_user_bid_projects", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Projects> getUserBidProjects(@RequestBody String user_id) {
        JSONObject jsonObject = new JSONObject(user_id);
        List<ProjectUserBidMapping> project = projectService.getUserBidProjects(jsonObject.getLong("user_id"));
        Map<String, Object> result = new HashMap();
        Iterable<User> users = userService.findAllUsers();
        result.put("rows", project);
        result.put("users", users);
        System.out.println("This is project" + project);
        return new ResponseEntity(result, HttpStatus.OK);

    }


    @PostMapping(value = "/hireUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Projects> hireUser(@RequestBody String details) {
        JSONObject jsonObject = new JSONObject(details);

        long freelancerId = jsonObject.getLong("free_lancer_id");
        long projectId = jsonObject.getLong("p_id");

        String message = projectService.hireUser(freelancerId, projectId);

        return new ResponseEntity(message, HttpStatus.OK);

    }


    @PostMapping(value = "/createProject", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Projects> createProject(@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam("title") String title,
                                                  @RequestParam("description") String description,
                                                  @RequestParam("skills_required") String skills_required,
                                                  @RequestParam("minimum_budget") String minimum_budget,
                                                  @RequestParam("maximum_budget") String maximum_budget,
                                                  @RequestParam("user_id") String user_id) {


        String fileName = "";
        String newFileName = "";
        if (file != null) {
            try {
                fileName = file.getOriginalFilename();

                newFileName = (new Date()).getTime() + "" + file.getOriginalFilename();
                byte[] bytes = file.getBytes();

                BufferedOutputStream buffStream =
                        new BufferedOutputStream(new FileOutputStream(new File("/home/murtaza/Desktop/FreeLancer/src/project-file/" + "" + newFileName)));
                buffStream.write(bytes);

                buffStream.close();

                String message = projectService.createProject(Integer.parseInt(user_id), newFileName, title, description, skills_required, Float.parseFloat(minimum_budget), Float.parseFloat(maximum_budget));
                return new ResponseEntity(message, HttpStatus.OK);
            } catch (Exception e) {
                return null;
            }
        } else {
            String message = projectService.createProject(Integer.parseInt(user_id), newFileName, title, description, skills_required, Float.parseFloat(minimum_budget), Float.parseFloat(maximum_budget));
            return new ResponseEntity(message, HttpStatus.OK);
        }


    }
}
