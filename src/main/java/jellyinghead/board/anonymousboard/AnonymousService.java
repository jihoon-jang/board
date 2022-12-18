package jellyinghead.board.anonymousboard;

import jellyinghead.board.anonymousboard.model.AnonymousPost;
import jellyinghead.board.anonymousboard.model.AnonymousPostData;
import jellyinghead.board.anonymousboard.model.AnonymousPostInfo;
import jellyinghead.board.anonymousboard.repository.AnonymousPostDataRepository;
import jellyinghead.board.anonymousboard.repository.AnonymousPostInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnonymousService {

    final AnonymousPostInfoRepository anonymousPostInfoRepository;
    final AnonymousPostDataRepository anonymousPostDataRepository;

    public AnonymousPost getAnonymousPost(int postId) {
        return new AnonymousPost(anonymousPostInfoRepository.getById(postId), anonymousPostDataRepository.getById(postId));
    }

    public Page<AnonymousPostInfo> getAnonymousPosts(Pageable pageable) {
        return anonymousPostInfoRepository.findAll(pageable);
    }

    public AnonymousPost addAnonymousPost(AnonymousPost anonymousPost) {
        //TODO IP나 유저 식별 가능한 값으로 암호화하고 짤라서 내보내도록 변경
        anonymousPost.setWriter("익명");
        AnonymousPostInfo anonymousPostInfo = anonymousPostInfoRepository.save(new AnonymousPostInfo(anonymousPost));
        return new AnonymousPost(anonymousPostInfo,
                anonymousPostDataRepository.save(new AnonymousPostData(anonymousPostInfo.getId(), anonymousPost.getBody())));
    }

}
