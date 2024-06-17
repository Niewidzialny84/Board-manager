package niewidzialny84.github.board.controllers;

import niewidzialny84.github.board.models.Card;
import niewidzialny84.github.board.repository.CardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardController
{
    private final CardRepository cardRepository;

    public CardController(CardRepository cardRepository)
    {
        this.cardRepository = cardRepository;
    }

    @GetMapping
    public List<Card> getBoardsCards()
    {
        return cardRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Card> getCard(@PathVariable Long id)
    {
        return cardRepository.findById((id).describeConstable().orElseThrow(RuntimeException::new));
    }

    @PostMapping
    public ResponseEntity createCard(@RequestBody Card board) throws URISyntaxException
    {
        Card savedCard = cardRepository.save((board));
        return ResponseEntity.created(new URI("/users/" + savedCard.getCardID())).body(savedCard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBoard(@PathVariable Long id)
    {
        cardRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
