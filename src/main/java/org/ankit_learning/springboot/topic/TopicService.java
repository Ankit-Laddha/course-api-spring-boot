package org.ankit_learning.springboot.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring description"),
            new Topic("generics", "Java Generics", "Generics description"),
            new Topic("lamda", "Java Lamda New", "Lamda description")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic newTopic) {
        for (Topic topic : topics) {
            if (topic.getId().equalsIgnoreCase(id)) {
                topics.set(topics.indexOf(topic), newTopic);
                break;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(it -> it.getId().equalsIgnoreCase(id));
    }
}
