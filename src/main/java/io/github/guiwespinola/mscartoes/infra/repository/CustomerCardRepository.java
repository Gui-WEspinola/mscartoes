package io.github.guiwespinola.mscartoes.infra.repository;

import io.github.guiwespinola.mscartoes.domain.CustomerCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerCardRepository extends JpaRepository<CustomerCard, Long> {

    List<CustomerCard> findByCpf(String cpf);
}
