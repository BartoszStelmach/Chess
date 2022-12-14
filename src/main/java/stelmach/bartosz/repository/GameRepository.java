package stelmach.bartosz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stelmach.bartosz.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
