package lab3.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lab3.entity.Bid;
import lab3.entity.ProjectUserBidMapping;
import lab3.services.BidService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.tags.Param;

import java.awt.*;
import java.util.*;
import java.util.List;

@Controller

@RequestMapping(path="/bid")

public class BidController {
    @Autowired
    private BidService bidService;

    @PostMapping(value = "/getAllBids", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> getAllBids(@RequestBody String projectDetail) {

        JSONObject jsonpObject = new JSONObject(projectDetail);
        System.out.println("I am in bids " +jsonpObject.getLong("project_id"));

          List<ProjectUserBidMapping> bids = bidService.getAllBids(jsonpObject.getLong("project_id"));

          System.out.println("I am in bids" + bids);

          Map<String, Object> result = new HashMap();
          result.put("rows", bids);
          return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping(value = "/submit_bid", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> submitBid(@RequestBody String details) {

        JSONObject jsonpObject = new JSONObject(details);
        System.out.println("I am in bids " +jsonpObject.getString("project_id"));

        long user_id = jsonpObject.getLong("user_id");
        long project_id = jsonpObject.getLong("project_id");
        long number_of_days = jsonpObject.getLong("no_of_days");
        float price = jsonpObject.getFloat("price");

        float avgBid = bidService.submitBid(user_id, project_id, number_of_days, price);

        Map<String, Object> result = new HashMap();
        result.put("avgBid", avgBid);


        System.out.println("Avg bid is " + avgBid);
        return new ResponseEntity(result, HttpStatus.OK);

    }

    @PostMapping(value = "/get-bid-value-for-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> getBidValueForUser(@RequestBody String details) {

        JSONObject jsonpObject = new JSONObject(details);

        long user_id = jsonpObject.getLong("user_id");
        long project_id = jsonpObject.getLong("project_id");

        List<Bid> bid = bidService.getUserBidValue(user_id, project_id);
        Map<String, Object> result = new HashMap();
        result.put("data_present", bid.size() > 0 ? true : false);
        result.put("rows", bid);
        return new ResponseEntity(result, HttpStatus.OK);

    }


}
