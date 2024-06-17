package niewidzialny84.github.board.controllers;

import niewidzialny84.github.board.models.Board;
import niewidzialny84.github.board.repository.BoardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boards")
public class BoardController
{
    private final BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository)
    {
        this.boardRepository = boardRepository;
    }

    @GetMapping
    public List<Board> getBoards()
    {
        return boardRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Board> getBoard(@PathVariable Long id)
    {
        return boardRepository.findById((id).describeConstable().orElseThrow(RuntimeException::new));
    }

    @PostMapping
    public ResponseEntity createBoard(@RequestBody Board board) throws URISyntaxException
    {
        Board savedBoard = boardRepository.save((board));
        return ResponseEntity.created(new URI("/users/" + savedBoard.getBoardID())).body(savedBoard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBoard(@PathVariable Long id)
    {
        boardRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
