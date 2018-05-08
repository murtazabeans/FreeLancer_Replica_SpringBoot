import React, { Component } from 'react';
import axios from 'axios';
import ProjectBid from './ProjectBid'

class AllProjectBids extends Component {

  constructor(){
    super();
    this.state = { data: [] };
  }
  
  componentDidMount(){
    this.loadBidsFromServer();
  }

  componentWillMount(){
    var self = this;
    axios.get('http://localhost:3001/check_session', { withCredentials: true })
    .then((response) => {
      if(response.data.session.email ==  undefined){
        window.location.href = "http://localhost:3000/signin";
      }
    })
  }

  loadBidsFromServer(){
    var self = this;
    let project_id = localStorage.getItem("project_id")
    axios.post("http://localhost:3001/bid/getAllBids", {project_id: project_id})
    .then(function (response) {
      if(response.data.rows != null){
        let user_detail = response.data.rows;
        console.log(user_detail);
        self.setState({
          data: response.data.rows
        })
        return;
      }
      return;
    })
  }

  render() {
    let bidList;
    if(this.state.data != null){
      bidList = this.state.data.map(bid => {
        let current_user_id = localStorage.user_id;
        let isProjectOwner = current_user_id == bid.bid_id ? true : false;
        let imageName = bid.profile_image_name == undefined ? "default.png" : bid.profile_image_name;
        return(
          <ProjectBid key = {bid.id} id = {bid.id} image_name = {imageName}  
          freelancer_name={bid.freelancer_name} free_lancer_id = {bid.employer_id} price={bid.bid_price} days = {bid.avg_days} 
          isProjectOwner = {isProjectOwner} assigned_to={bid.assigned_to}  />
        )
      })
    }
    return (
      <div>
        <table class="table details-table">
          <thead class = "table-header">
            <tr>
              <th scope="col">Image</th>
              <th scope="col">FreeLancer Name</th>
              <th scope="col">Bid Price($)</th>
              <th scope="col">Period in Days</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
            { bidList }
          </tbody>
        </table>
      </div>
    )
  }
}

export default AllProjectBids;
