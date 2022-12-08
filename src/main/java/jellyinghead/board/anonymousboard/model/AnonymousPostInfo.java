package jellyinghead.board.anonymousboard.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "anonymous_post_info")
public class AnonymousPostInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isNotice;
    private String writer;
    private String title;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    public AnonymousPostInfo(AnonymousPost anonymousPost) {
        this.id = anonymousPost.getId();
        this.isNotice = anonymousPost.isNotice();
        this.writer = anonymousPost.getWriter();
        this.title = anonymousPost.getTitle();
        this.createdAt = anonymousPost.getCreatedAt();
        this.updatedAt = anonymousPost.getUpdatedAt();
    }

}
