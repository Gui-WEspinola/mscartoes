package io.github.guiwespinola.mscartoes.application;

import io.github.guiwespinola.mscartoes.domain.CustomerCard;
import io.github.guiwespinola.mscartoes.infra.repository.CustomerCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerCardService {

    private final CustomerCardRepository customerCardRepository;

    public List<CustomerCard> listCardsByCpf(String cpf) {
        return customerCardRepository.findByCpf(cpf);
    }
}
