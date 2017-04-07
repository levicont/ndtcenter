package com.lvg.tests.models.com.lvg.tests.controllers

import com.lvg.ndtcenter.config.AppConfig
import com.lvg.ndtcenter.controllers.CommonController
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import java.time.LocalDate

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringJUnit4ClassRunner)
@WebAppConfiguration
class CommonControllerTest {

    @Autowired
    WebApplicationContext wac

    private MockMvc mockMvc

    @Before
    void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(new CommonController()).build()
    }

    @Test
    void getMainPage(){
        mockMvc.perform(get('/')).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
    }

    @Test
    void getHomePage(){
        mockMvc.perform(get('/home')).andDo(MockMvcResultHandlers.print()).
                andExpect(status().is3xxRedirection()).
                andExpect(model().attribute('date', LocalDate.now()))
    }
}
