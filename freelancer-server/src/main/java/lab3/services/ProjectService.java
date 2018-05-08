package lab3.services;

import lab3.entity.Bid;
import lab3.entity.ProjectBidMapping;
import lab3.entity.ProjectUserBidMapping;
import lab3.entity.Projects;
import lab3.repository.BidRepository;
import lab3.repository.ProjectBidRepository;
import lab3.repository.ProjectRepository;
import lab3.repository.ProjectUserBidMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectUserBidMappingRepository projectUserBidMappingRepository;

    @Autowired
    private ProjectBidRepository projectBidRepository;
    @Autowired
    private BidRepository bidRepository;

    public Iterable<Projects> findAll() {
        return projectRepository.findAll();
    }

    public List<ProjectBidMapping> getProjectDetail(Long id){
        return  projectBidRepository.findProjectDetail(id);
    }

    public  List<ProjectUserBidMapping> getUserPublishedProjects(long id){
        return  projectUserBidMappingRepository.findUserPublishedProjects(id);
    }

    public  List<ProjectUserBidMapping> getUserBidProjects(long id){
        return  projectUserBidMappingRepository.findUserBidProjects(id);
    }

    public  List<ProjectBidMapping> findAllProjects(){
        return  projectBidRepository.findAllProjects();
    }

    public String hireUser(long freelancerId, long projectId){

        List<Bid> bids = bidRepository.findByProjectId(projectId);

        for(int i = 0; i < bids.size(); i++){
            bids.get(i).setStatus("Rejected");
            bidRepository.save(bids.get(i));
        }
        List<Bid> accepted_bid = bidRepository.findByUserIdAndProjectId(freelancerId, projectId);

        accepted_bid.get(0).setStatus("Accepted");
        bidRepository.save(accepted_bid.get(0));

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, (int)accepted_bid.get(0).getNumber_of_days());

        Optional<Projects> projects = projectRepository.findById(projectId);

        projects.get().setAssigned_to("" + freelancerId + "");
        projects.get().setDate_of_completion(cal.getTime());

        projectRepository.save(projects.get());
        return "FreeLancer Hired";
    }

    public  String createProject(int user_id, String newFileName, String title, String description, String skills_required, float minimum_budget, float maximum_budget){
        Projects project = new Projects();
        project.setTitle(title);
        project.setCreated_at(new Date());
        project.setDescription(description);
        project.setFile_name(newFileName);
        project.setSkills_required(skills_required);
        project.setMin_budget(minimum_budget);
        project.setMax_budget(maximum_budget);
        project.setUserId(user_id);
        projectRepository.save(project);
        return "Project Created";
    }

}
