package jellyinghead.board.anonymousboard.repository;

import jellyinghead.board.anonymousboard.model.AnonymousPostData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnonymousPostDataRepository extends JpaRepository<AnonymousPostData, Integer> {
}
