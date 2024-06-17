package niewidzialny84.github.board.repository;

import niewidzialny84.github.board.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long>
{
}
