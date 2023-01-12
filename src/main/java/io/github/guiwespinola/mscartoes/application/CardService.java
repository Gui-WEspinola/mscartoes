package io.github.guiwespinola.mscartoes.application;

import io.github.guiwespinola.mscartoes.domain.Card;
import io.github.guiwespinola.mscartoes.infra.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor // Cria construtores só os com argumentos obrigatórios (que tem final)
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> getCardIncomeLessThanEqual(Long income) {
        var incomeBigDecimal = BigDecimal.valueOf(income);
        return cardRepository.findByIncomeLessThanOrEqual(incomeBigDecimal);
    }


}
