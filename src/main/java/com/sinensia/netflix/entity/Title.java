package com.sinensia.netflix.entity;

import lombok.*;
import lombok.experimental.Accessors;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (exclude = {"director","actor","category"})
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "title_director")
    Set<Director> director;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "title_actor")
    Set<Actor> actor;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "title_category")
    Set<Category> category;

    @NotBlank
    private String date_added;

    @NotBlank
    private String release_year;

    @NotBlank
    private String rating;

    @NotBlank
    private String duration;

    @Column(length = 4095)
    private String description;

    @Min(0)
    @Max(10)
    private Float user_rating;

    @Min(0)
    private Integer num_ratings;

}
