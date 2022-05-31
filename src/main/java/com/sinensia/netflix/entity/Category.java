package com.sinensia.netflix.entity;

import lombok.*;
import lombok.experimental.Accessors;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "title")
@ToString(exclude = "title")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "category")
    Set<Title> title;
}
