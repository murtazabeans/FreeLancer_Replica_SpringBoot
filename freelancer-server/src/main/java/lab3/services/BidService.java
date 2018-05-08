package lab3.services;

import lab3.entity.Bid;
import lab3.entity.ProjectUserBidMapping;
import lab3.repository.BidRepository;
import lab3.repository.ProjectUserBidMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BidService {
    @Autowired
    private BidRepository bidRepository;
    @Autowired
    ProjectUserBidMappingRepository projectUserBidMappingRepository;

    public List<ProjectUserBidMapping> getAllBids(Long id) {
        List<ProjectUserBidMapping> bids = new ArrayList<>();
        System.out.println("My id is " + id);
        bids = projectUserBidMappingRepository.findAllBids(id);
        return bids;
    }

    public List<Bid> getUserBidValue(long user_id, long project_id) {
        List<Bid> bids = new ArrayList<>();
        bids = bidRepository.findByUserIdAndProjectId(user_id, project_id);

        System.out.println("I am inside bid" + bids);
        return bids;
    }



    public float submitBid(long user_id, long project_id, long number_of_days, float price) {
        List<Bid> bid = bidRepository.findByUserIdAndProjectId(user_id, project_id);
        System.out.println("User is " + user_id + " Project id is " + project_id);
        if(bid.size() > 0){
            bid.get(0).setPrice(price);
            bid.get(0).setNumber_of_days(number_of_days);
            bidRepository.save(bid.get(0));
        }
        else
        {
            Bid newBid = new Bid();
            newBid.setPrice(price);
            newBid.setNumber_of_days(number_of_days);
            newBid.setCreated_at(new Date());
            newBid.setProjectId(project_id);
            newBid.setUser_id(user_id);
            newBid.setStatus("Pending");
            bidRepository.save(newBid);
        }

        List<Bid> all_bids = bidRepository.findByProjectId(project_id);
        float avgBid = 0;
        float total_bids = all_bids.size();
        float bidPrice = 0;
        for(int i=0; i< all_bids.size(); i++){
            bidPrice += all_bids.get(i).getPrice();
        }
        avgBid = total_bids == 0 ? 0 : bidPrice/total_bids;
        return  avgBid;
    }
}
