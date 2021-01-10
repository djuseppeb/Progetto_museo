package it.gruppo5.smartmuseumwapp.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;

import it.gruppo5.smartmuseumwapp.service.Manager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class WAppControllerTest {
	WAppController controller = new WAppController();
	Manager manager = new Manager();
	@Autowired
	private MockMvc mockMvc;
	

	@Test
	void testGetHomePage() throws Exception {
        this.mockMvc.perform(get("/home"))
        .andExpect(status().isOk()) //verify if http status is correct
        .andExpect(view().name("homePage"))
        .andExpect(model().attributeExists("visitors"))
        .andExpect(model().attribute("visitors", notNullValue())) //verify if value is not null
        .andExpect(model().attribute("visitors", manager.getNumOfVisitors())) //verify if value is correct
        .andExpect(model().attributeExists("permission"))
        .andExpect(model().attribute("permission", notNullValue())) //verify if value is not null
        .andExpect(model().attribute("artworks", notNullValue())) //verify if value is not null
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

	@Test
	void testGetArtworksPage() throws Exception {
        this.mockMvc.perform(get("/artworks"))
        .andExpect(status().isOk()) //verify if http status is correct
        .andExpect(view().name("artworksPage"))
        .andExpect(model().attributeExists("artworks"))
        .andExpect(model().attribute("artworks", notNullValue())) //verify if value is not null
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

	@Test
	void testGetArtworkPage() throws Exception {
        this.mockMvc.perform(get("/artwork?ID=9"))
        .andExpect(status().isOk()) //verify if http status is correct
        .andExpect(view().name("artworkPage"))
        .andExpect(model().attributeExists("artwork"))
        .andExpect(model().attribute("artwork", notNullValue())) //verify if value is not null
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
        
	}

	@Test
	void testGetCupon() throws Exception {
        this.mockMvc.perform(get("/coupon"))
        .andExpect(status().isOk()) //verify if http status is correct
        .andExpect(view().name("couponPage"))
        .andExpect(model().attributeExists("ticket"))
        .andExpect(model().attribute("ticket", notNullValue())) //verify if value is not null
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

	@Test
	void testGetGalleryPage() throws Exception {
        this.mockMvc.perform(get("/gallery"))
        .andExpect(status().isOk())
        .andExpect(view().name("galleryPage"))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

}
