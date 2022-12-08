package jellyinghead.board.anonymousboard.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "anonymous_post_data")
public class AnonymousPostData {

    @Id
    private int id;
    private String body;

    public AnonymousPostData(int id, String body) {
        this.id = id;
        this.body = body;
    }

}
