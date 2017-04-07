package com.lvg.tests.models.com.lvg.tests.controllers
import com.lvg.ndtcenter.config.AppConfig
import com.lvg.ndtcenter.config.R
import com.lvg.ndtcenter.services.DirectionService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = [AppConfig.class])
class DirectionUcnkControllerTest {

    @Autowired
    DirectionService directionService
    @Autowired
    WebApplicationContext wac

    private MockMvc mockMvc

    @Before
    void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build()
    }

    @Test
    void getAllTest(){
        mockMvc.perform(MockMvcRequestBuilders.get('/directions')).
                andDo(MockMvcResultHandlers.print()).
                andExpect(status().isOk()).
                andExpect(model().attribute('content',R.Templates.DIRECTION_LIST_TEMPLATE))

    }

    @Test
    void getDirectionTest(){
        def id = directionService.findAll().get(0).directionId
        assert id != null
        String idPath = id.toString()
        mockMvc.perform(MockMvcRequestBuilders.get("/directions/${idPath}")).
                andDo(MockMvcResultHandlers.print()).
                andExpect(status().isOk())


    }

}
