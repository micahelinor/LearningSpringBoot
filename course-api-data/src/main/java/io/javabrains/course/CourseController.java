package io.javabrains.course;

import io.javabrains.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired  //the variable topicservice has a dependency
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}") //{x} means that x is a variable
    public Course getCourse(@PathVariable String id) {    //@PathVariable  is indicating that id is variable that will come from the path
        return courseService.getCourse(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {    //Request payload would have a json representation of the topic
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);                   //then Spring MVC converts it from json to object "Topic"
    }

    @RequestMapping(method= RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course, id);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }


}
