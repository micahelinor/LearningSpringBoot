package springbootquickstart.topic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class TopicService{

    private List<Topic> topics = Arrays.asList(
            new Topic("Spring", "Spring", "Spring Framework"),
            new Topic("Java", "Java", "Programming Language"),
            new Topic("Maven", "Maven", "Dependency Manager")
    );

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        //Makes the topic list into stream
        //Then filter any topic who has that id
        //chooses the first  topic that has the id
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

}
