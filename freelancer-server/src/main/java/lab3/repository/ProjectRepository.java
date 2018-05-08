package lab3.repository;

import lab3.entity.Projects;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Projects, Long> {

    List<Projects> findByUserId(Long id);
}
