package com.mallon.cardatabase.web;
import com.mallon.cardatabase.CardatabaseApplication;
import com.mallon.cardatabase.domain.dto.Owner;
import com.mallon.cardatabase.domain.dao.OwnerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={CardatabaseApplication.class})
@AutoConfigureMockMvc
public class CarControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    public OwnerRepository ownerRepoMock;

    @Before
    public void init(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testReturnUserByName() throws Exception{
        when(ownerRepoMock.findOwnerByFirstname("Lucy")).thenReturn(new Owner("Lucy","Smith"));

        this.mockMvc.perform( MockMvcRequestBuilders
                .get("/owner/Lucy")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname").value("Lucy"));
    }

}