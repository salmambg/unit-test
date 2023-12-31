package info.leanix.unittest.controller;

import info.leanix.unittest.model.Item;
import info.leanix.unittest.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Arrays;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    public void dummyItem_basic() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
    }

    @Test
    public void itemBusinessService_basic() throws Exception {
        when(itemService.retreiveHardCodedItem()).thenReturn(new Item(2,"Item 2", 10, 100));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-business-service")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 2,\"name\":\"Item 2\",\"price\":10,\"quantity\":100}"))
                .andReturn();
    }

    @Test
    public void retrieveAllItems_basic() throws Exception {
        when(itemService.retrieveAllItem()).thenReturn(
                Arrays.asList(new Item(2,"Item2",10,10),
                        new Item(3,"Item3",20,20))
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-item-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:3,name:Item3,price:20}, {id:2,name:Item2,price:10}]"))
                .andReturn();
    }
}
