package io.github.guiwespinola.mscartoes.infra.repository;

import io.github.guiwespinola.mscartoes.domain.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {

    List<ClientCard> findByCpf(String cpf);
}
