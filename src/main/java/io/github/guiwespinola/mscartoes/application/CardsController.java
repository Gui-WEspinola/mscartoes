package io.github.guiwespinola.mscartoes.application;

import io.github.guiwespinola.mscartoes.application.dto.CardSaveRequest;
import io.github.guiwespinola.mscartoes.domain.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CardsController {

    private final CardService cardService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Card> saveCard(@RequestBody CardSaveRequest request) {
        var card = request.toModel();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("name={name}")
                .buildAndExpand(card.getName())
                .toUri();
        return ResponseEntity.created(uri).body(cardService.save(card));
    }

    @GetMapping(params = "income") // /cards?income=5000
    public ResponseEntity<List<Card>> getCardIncomeLessThan(@RequestParam Long income) {
        List<Card> cardList = cardService.getCardIncomeLessThanEqual(income);
        return ResponseEntity.ok(cardList);
    }

}
