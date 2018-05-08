package Lab3;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab3.Application;
import lab3.controller.BidController;
import lab3.controller.ProjectController;
import lab3.controller.UserController;
import lab3.entity.Projects;
import lab3.entity.User;
import lab3.repository.BidRepository;
import lab3.repository.ProjectRepository;
import lab3.repository.UserRepository;
import lab3.services.BidService;
import lab3.services.ProjectService;
import lab3.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringRunner.class)

@ContextConfiguration(classes= Application.class)
@WebMvcTest(BidController.class)

public class BidControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserService userService;

    @MockBean
    BidService bidService;

    @MockBean
    ProjectService projectService;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BidRepository projectRepository;

    @MockBean
    private Projects project;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testGetAllBids() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/bid/getAllBids")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"project_id\": \"39\"}");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testGetBidValueForUser() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/bid/get-bid-value-for-user")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"project_id\": \"39\", \"user_id\": \"201\"}");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }





}
