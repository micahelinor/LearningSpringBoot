package springbootquickstart.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    @Autowired  //the variable topicservice has a dependency
    private TopicService topicservice;

    @RequestMapping("/topic")
    public List<Topic> getAllTopics() {
        return topicservice.getAllTopics();
    }

    @RequestMapping("/topic/{id}") //{x} means that x is a variable
    public Topic getTopic(@PathVariable String id) {    //@PathVariable  is indicating that id is variable that will come from the path
        return topicservice.getTopic(id);
    }
}
