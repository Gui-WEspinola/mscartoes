package io.github.guiwespinola.mscartoes.application.dto;

import io.github.guiwespinola.mscartoes.domain.Card;
import io.github.guiwespinola.mscartoes.domain.CardFlag;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveRequest {

    private String name;
    private CardFlag cardFlag;
    private BigDecimal income;
    private BigDecimal creditLimit;

    public Card toModel() {
        return new Card(name, cardFlag, income, creditLimit);
    }

}
