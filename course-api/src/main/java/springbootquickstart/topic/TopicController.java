package springbootquickstart.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired  //the variable topicservice has a dependency
    private TopicService topicservice;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicservice.getAllTopics();
    }

    @RequestMapping("/topics/{id}") //{x} means that x is a variable
    public Topic getTopic(@PathVariable String id) {    //@PathVariable  is indicating that id is variable that will come from the path
        return topicservice.getTopic(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic) {    //Request payload would have a json representation of the topic
        topicservice.addTopic(topic);                   //then Spring MVC converts it from json to object "Topic"
    }

    @RequestMapping(method= RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicservice.updateTopic(topic, id);
    }


}
