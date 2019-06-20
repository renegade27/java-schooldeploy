package com.lambdaschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Student;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIntegrationTest
{
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception
    {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void listAllStudents()
    {
    }

    @Test
    public void addNewStudent() throws Exception
    {
        Student s4 = new Student("Tiger");
        s4.setStudid(29);

        ObjectMapper mapper = new ObjectMapper();
        String stringS4 = mapper.writeValueAsString(s4);

        given().contentType("application/json").body(stringS4).when().post("/students/student/add").then().statusCode(201);

    }
}