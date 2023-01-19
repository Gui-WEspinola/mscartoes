package io.github.guiwespinola.mscartoes.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.guiwespinola.mscartoes.domain.Card;
import io.github.guiwespinola.mscartoes.domain.CardRequestData;
import io.github.guiwespinola.mscartoes.domain.CustomerCard;
import io.github.guiwespinola.mscartoes.infra.repository.CardRepository;
import io.github.guiwespinola.mscartoes.infra.repository.CustomerCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestCardSubscriber {

    private final CardRepository cardRepository;

    private final CustomerCardRepository customerCardRepository;

    @RabbitListener(queues = "${mq.queues.issue-card}")
    public void recieveCardRequest(String payload) {
        // é preciso desserializar os dados obtidos via mensageria e convertidos em json no msavaliaçaocredito

        try { //como temos um listener, o lançamento da exception não será visto, ao contrário do publisher
            var mapper = new ObjectMapper();
            CardRequestData cardRequestData = mapper.readValue(payload, CardRequestData.class);
            Card card = cardRepository.findById(cardRequestData.getCardId()).orElseThrow();
            CustomerCard customerCard = new CustomerCard();
            customerCard.setCard(card);
            customerCard.setCpf(cardRequestData.getCpf());
            customerCard.setCreditLimit(cardRequestData.getCreditLimit());

            customerCardRepository.save(customerCard);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
