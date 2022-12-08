package jellyinghead.board.anonymousboard.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AnonymousPost {

    private int id;
    private boolean isNotice;
    private String writer;
    private String title;
    private String body;
    private Instant createdAt;
    private Instant updatedAt;

    public AnonymousPost(AnonymousPostInfo anonymousPostInfo, AnonymousPostData anonymousPostData) {
        this.id = anonymousPostInfo.getId();
        this.isNotice = anonymousPostInfo.isNotice();
        this.writer = anonymousPostInfo.getWriter();
        this.title = anonymousPostInfo.getTitle();
        this.createdAt = anonymousPostInfo.getCreatedAt();
        this.updatedAt = anonymousPostInfo.getUpdatedAt();
        this.body = anonymousPostData.getBody();
    }

}
