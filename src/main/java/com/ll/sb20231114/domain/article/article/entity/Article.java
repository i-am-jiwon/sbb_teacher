package com.ll.sb20231114.domain.article.article.entity;

import com.ll.sb20231114.domain.member.member.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Article {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne
    private Member author;
    private String title;
    private String body;

    public Article(Member author, String title, String body) {
        this.author = author;
        this.title = title;
        this.body = body;
    }
}
