package com.stepasha.zoo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stepasha.zoo.controllers.ZooController;
import com.stepasha.zoo.models.Animal;
import com.stepasha.zoo.models.Zoo;
import com.stepasha.zoo.models.ZooAnimals;
import com.stepasha.zoo.services.ZooService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@WebMvcTest(value = ZooController.class)
public class ZooControllerTest {

  @Autowired
  private MockMvc mockMvc;

   @MockBean
   private ZooService zooService;

   private ArrayList<Zoo> zooList;

    @Before
    public void setUp() throws Exception {
       zooList = new ArrayList<>();
        ArrayList<ZooAnimals> thisAnimal = new ArrayList<>();
        Zoo zooType1 = new Zoo("Monkey Zoo", thisAnimal);
        zooType1.setZooid(1);
        Zoo zooType2 = new Zoo("Total Monkey Business Zoo", thisAnimal);
        zooType2.setZooid(2);
        zooList.add(zooType1);
        zooList.add(zooType2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAllZoos() throws Exception {

        String apiUrl = "/zoos/zoos";
        Mockito.when(zooService.findAllZoos()).thenReturn(zooList);

        RequestBuilder reqbuilder = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);
        MvcResult r = mockMvc.perform(reqbuilder).andReturn(); // this could throw an exception
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(zooList);
        System.out.println("Expect: " + er);
        System.out.println("Actual: " + tr);

        System.out.println("Expect: " + er);
        System.out.println("Actual: " + tr);
        assertEquals("Rest API Return List", er, tr );
    }

    @Test
    public void findZooById() {
    }

    @Test
    public void findZooByName() {
    }

    @Test
    public void updateZoo() {
    }

    @Test
    public void addNewZoo() {
    }

    @Test
    public void deleteZooById() {
    }

    @Test
    public void deleteZooAnimalByIds() {
    }

    @Test
    public void postZooAnimalByIds() {
    }
}