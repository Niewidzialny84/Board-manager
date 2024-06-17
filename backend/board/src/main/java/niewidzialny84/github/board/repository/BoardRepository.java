package niewidzialny84.github.board.repository;

import niewidzialny84.github.board.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>
{
}
