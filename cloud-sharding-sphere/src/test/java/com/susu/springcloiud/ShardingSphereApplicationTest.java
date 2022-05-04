package com.susu.springcloiud;

import com.susu.cloud.ShardingSphereApplication;
import com.susu.cloud.dao.CourseDao;
import com.susu.cloud.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ShardingSphereApplication.class)
public class ShardingSphereApplicationTest {

    @Autowired
    private CourseDao courseDao;

    @Test
    public void addCourse() {
        Course course = new Course();
        course.setCid(200L);
        course.setCname("java");
        course.setUserId(100L);
        course.setCstatus("Normal");
        int insert = courseDao.insert(course);
        System.out.println(insert);
    }
}
