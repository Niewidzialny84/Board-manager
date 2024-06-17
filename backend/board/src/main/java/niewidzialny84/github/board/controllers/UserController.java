package niewidzialny84.github.board.controllers;

import niewidzialny84.github.board.models.Board;
import niewidzialny84.github.board.models.User;
import niewidzialny84.github.board.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController
{
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id)
    {
        return userRepository.findById((id).describeConstable().orElseThrow(RuntimeException::new));
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) throws URISyntaxException
    {
        User savedUser = userRepository.save((user));
        return ResponseEntity.created(new URI("/users/" + savedUser.getUserID())).body(savedUser);
    }
}
