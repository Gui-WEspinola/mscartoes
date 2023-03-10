package io.github.guiwespinola.mscartoes.application.representation;

import io.github.guiwespinola.mscartoes.domain.CustomerCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardsByClientResponse {

    private String name;

    private String cardFlag;

    private BigDecimal allowedCreditLimit;

    public static CardsByClientResponse fromModel(CustomerCard model) {
        return new CardsByClientResponse(
                model.getCard().getName(),
                model.getCard().getFlag().toString(),
                model.getCreditLimit());
    }
}
