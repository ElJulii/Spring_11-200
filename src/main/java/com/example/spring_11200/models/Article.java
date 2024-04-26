package com.example.spring_11200.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    private String name;
    private String type;

    @Column(length = 1000)
    private String text;

    @ManyToOne
    @JoinTable(name = "article_author")     //Here we do not do it like the code below because
    private User author;                    //we are gonna use the author type User like an id
                                            // so Spring knows that we want it as an id
    @ManyToMany
    @JoinTable(name = "article_likes",
            joinColumns = @JoinColumn(name = "articleId", referencedColumnName = "articleId"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> likes;
}
