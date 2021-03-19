package mapit.mapit.model.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Getter
@NoArgsConstructor
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    private String description;

    @Column(name = "image_path")
    @NotEmpty
    private String imagePath;

    @Column(name = "image_latitude")
    private Double imageLatitude;

    @Column(name = "image_longitude")
    private Double imageLongitude;

    @Column(name = "image_coordinates_are_real")
    private boolean imageCoordinatesAreReal = false;

    @Column(name = "votes")
    @OneToMany
    private List<VoteEntity> votes;

    @OneToMany
    private List<CommentEntity> comments;

    @ManyToOne
    private UserEntity userId;

    private LocalDateTime date;

}
