package stelmach.bartosz.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "move_placeholder")
public class MovePlaceholder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@ManyToOne
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;

	private String notation;

	public MovePlaceholder(Game game, String notation) {
		this.game = game;
		this.notation = notation;
	}

}
