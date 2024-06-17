package niewidzialny84.github.board.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue
    private Long userID;

    private String name;
    private String key;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Board> boardList = new ArrayList<>();

    public User(String name, String key)
    {
        this.name = name;
        this.key = key;
    }

    public User(String name)
    {
        this.name = name;
    }

    public User()
    {
    }
}
