package io.github.guiwespinola.mscartoes.infra.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class IssueCardSubscriber {

    @RabbitListener(queues = "${mq.queues.issue-card}")
    public void recieveCardRequest(String payload) {
        System.out.println(payload);
    }
}
