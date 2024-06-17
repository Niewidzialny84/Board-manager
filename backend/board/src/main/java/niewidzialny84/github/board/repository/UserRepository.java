package niewidzialny84.github.board.repository;

import niewidzialny84.github.board.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
}
