package niewidzialny84.github.board.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "board")
public class Board
{
    @Id
    @GeneratedValue
    private Long boardID;

    private String title;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user.userID")
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<Card> cardList = new ArrayList<>();
}
