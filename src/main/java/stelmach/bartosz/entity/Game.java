package stelmach.bartosz.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String whiteName;
    private String blackName;
    @Transient @JsonInclude
    private List<String> moves = new ArrayList<>();
//    private List<Move> moves = new ArrayList<>();

    public Game(String whiteName, String blackName) {
        this.whiteName = whiteName;
        this.blackName = blackName;
    }

//    public void addMove(Move move) {
//        moves.add(move);
//    }
}
