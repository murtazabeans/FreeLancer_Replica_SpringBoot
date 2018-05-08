package lab3.repository;

import lab3.entity.ProjectUserBidMapping;
import lab3.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

public interface ProjectUserBidMappingRepository extends Repository<ProjectUserBidMapping, Long> {

    @Query(
            value = "select b.id,b.title, b.user_id as employer_id, b.user_id as bid_price, b.assigned_to as freelancer_name, b.title as profile_image_name, b.id as bid_id,b.date_of_completion," +
                    "avgTable.avgDays as avg_days ,C.name as owner, CASE WHEN b.assigned_to is null or trim(b.assigned_to) = '' " +
                    "Then '' ELSE  (select D.name from user D where D.id=b.assigned_to) END as assigned_to from " +
                    "(SELECT b.id,COALESCE(avg(a.number_of_days),0) as avgDays from projects b left OUTER JOIN bid a on a.project_id=b.id group by b.id) as avgTable" +
                    ",projects b, user C, bid X where b.user_id = :id and b.user_id=C.id and avgTable.id=b.id group by b.id", nativeQuery = true
    )
    List<ProjectUserBidMapping> findUserPublishedProjects(@Param("id") Long id);

    @Query(
            value = "select b.id as id, X.id as bid_id, b.user_id as employer_id, c.name as freelancer_name, c.name as owner, c.name as profile_image_name, b.date_of_completion, X.number_of_days as bid_price, averageTable.avgDays as avg_days, b.title as title, b.assigned_to as assigned_to, averageTable.project_id, X.number_of_days, c.name, c.id from" +
            " (select avg(b.number_of_days) as avgDays, p.title, b.project_id, p.assigned_to,p.user_id from bid b,projects p where b.project_id=p.id group by p.id) " +
            "as averageTable, bid X, projects b ,user c where X.project_id=averageTable.project_id and X.user_id= :id and" +
            " b.user_id=c.id and b.id = X.project_id", nativeQuery = true
    )
    List<ProjectUserBidMapping> findUserBidProjects(@Param("id") Long id);

    @Query(
            value = "Select b.id as id, u.id as employer_id, p.user_id as bid_id, p.title, p.date_of_completion, u.name as freelancer_name, u.profile_image_name as profile_image_name, p.user_id as owner, p.assigned_to as assigned_to, b.price as bid_price, " +
                    "b.number_of_days as avg_days from user u, projects p, bid b where b.user_id = u.id and b.project_id = p.id and p.id = :id", nativeQuery = true
    )
    List<ProjectUserBidMapping> findAllBids(@Param("id") Long id);
}
