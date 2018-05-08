package lab3.repository;

import lab3.entity.Bid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BidRepository extends CrudRepository<Bid, Long> {
    List<Bid> findByProjectId(Long id);
    List<Bid> findByUserIdAndProjectId(long userId, long projectId );



}

