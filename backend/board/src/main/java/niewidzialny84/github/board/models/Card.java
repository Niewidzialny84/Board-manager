package niewidzialny84.github.board.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import niewidzialny84.github.board.enums.CardState;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "card")
public class Card
{
    @Id
    @GeneratedValue
    private Long cardID;

    private String title;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board.boardID")
    private Board board;

    private CardState cardState;
}
