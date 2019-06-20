package com.lambdaschool.school.service;

import com.lambdaschool.school.SchoolApplication;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.repository.InstructorRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolApplication.class)
public class CourseServiceImplTest
{
    @Autowired
    private CourseService courseService;

    @Autowired
    private InstructorRepository instructrepo;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void findCourseById()
    {
        assertEquals("Data Science", courseService.findCourseById(4).getCoursename());
    }

    @Test
    public void findAll()
    {
    }

    @Test
    public void getCountStudentsInCourse()
    {
    }

    @Test
    public void delete()
    {
        courseService.delete(4);
        assertEquals(5, courseService.findAll().size());
    }

    @Test (expected = EntityNotFoundException.class)
    public void deleteNotFound()
    {
        courseService.delete(4444);
        assertEquals(5, courseService.findAll().size());
    }

    @Test
    public void save()
    {
        Course cs = new Course("My New Course", instructrepo.findById(2L).orElseThrow(() -> new EntityNotFoundException(Long.toString(2L))));

        Course addCourse = courseService.save(cs);

        assertNotNull(addCourse);

        Course foundCourse = courseService.findCourseById(addCourse.getCourseid());
        assertEquals(addCourse.getCoursename(), foundCourse.getCoursename());
    }
}