package lab3.repository;

import lab3.entity.ProjectBidMapping;
import lab3.entity.ProjectUserBidMapping;
import lab3.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

public interface ProjectBidRepository extends Repository<ProjectBidMapping, Long> {

    @Query(
            value = "Select projects.*, AVG(bid.number_of_days) as days, projects.title as name from projects INNER JOIN bid on (projects.id = bid.project_id) where projects.id = :id", nativeQuery = true
    )

    List<ProjectBidMapping> findProjectDetail(@Param("id") Long id);

    @Query(
            value = "SELECT projects.*, user.name as name, count(bid.project_id) as days from projects left join bid on" +
                    "(projects.id = bid.project_id) LEFT JOIN user on (projects.user_id = user.id) group by projects.id", nativeQuery = true
    )
    List<ProjectBidMapping> findAllProjects();
}
