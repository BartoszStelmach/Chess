package stelmach.bartosz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stelmach.bartosz.entity.Game;
import stelmach.bartosz.entity.MovePlaceholder;

import java.util.List;

@Repository
public interface MoveRepository extends JpaRepository<MovePlaceholder, Integer> {

	List<MovePlaceholder> findByGame(Game game);

}
