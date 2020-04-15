package org.ankit_learning.springboot.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    //@RequestMapping(value = "/topics", method = RequestMethod.POST)
    @PostMapping(value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @PutMapping(value = "/topics/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
         topicService.updateTopic(id, topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public void updateTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }

}
