package mapit.mapit.model.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "authorities")
public class AuthoritiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum ROLE{
        ADMIN,
        MODERATOR,
        USER
    }

    @ManyToOne
    private UserEntity userId;
}
