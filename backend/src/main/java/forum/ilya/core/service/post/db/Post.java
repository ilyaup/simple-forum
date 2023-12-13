package forum.ilya.core.service.post.db;

import forum.ilya.core.service.user.db.UserAccount;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    @Column(name = "content")
    private String content;

    @Column(name = "likes")
    private long likes;
}
