package io.github.guiwespinola.mscartoes.application;

import io.github.guiwespinola.mscartoes.domain.ClientCard;
import io.github.guiwespinola.mscartoes.infra.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {

    private final ClientCardRepository clientCardRepository;

    public List<ClientCard> listCardsByCpf(String cpf) {
        return clientCardRepository.findByCpf(cpf);
    }
}
