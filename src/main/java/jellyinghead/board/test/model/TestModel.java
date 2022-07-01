package jellyinghead.board.test.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "test_table")
public class TestModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int no;

    private String name;
}
