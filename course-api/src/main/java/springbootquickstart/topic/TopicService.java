package springbootquickstart.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class TopicService{

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Spring", "Spring", "Spring Framework"),
            new Topic("Java", "Java", "Programming Language"),
            new Topic("Maven", "Maven", "Dependency Manager")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        //Makes the topic list into stream
        //Then filter any topic who has that id
        //chooses the first  topic that has the id
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id) {
        for(int i = 0; i <topics.size(); i++) {
            Topic t = topics.get(i);
            if(t.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }
}
