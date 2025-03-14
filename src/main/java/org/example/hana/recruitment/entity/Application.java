package org.example.hana.recruitment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.example.hana.global.BaseEntity;
import org.example.hana.user.entity.User;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "applications")
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_id", "recruitment_post_id"})
        }
)
public class Application extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "recruitment_post_id")
    private RecruitmentPost recruitmentPost;

}
