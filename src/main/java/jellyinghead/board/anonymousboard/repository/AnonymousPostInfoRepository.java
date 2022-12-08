package jellyinghead.board.anonymousboard.repository;

import jellyinghead.board.anonymousboard.model.AnonymousPostInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnonymousPostInfoRepository extends JpaRepository<AnonymousPostInfo, Integer> {
}
