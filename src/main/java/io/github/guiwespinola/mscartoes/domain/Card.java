package io.github.guiwespinola.mscartoes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CardFlag flag;

    private BigDecimal income;

    private BigDecimal creditLimit;

    public Card(String name, CardFlag flag, BigDecimal income, BigDecimal creditLimit) {
        this.name = name;
        this.flag = flag;
        this.income = income;
        this.creditLimit = creditLimit;
    }
}
