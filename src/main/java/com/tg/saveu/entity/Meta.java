package com.tg.saveu.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "metas")
public class Meta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "description", nullable = false, length = 200)
    private String description;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;
    @Column(name = "goal", nullable = false, length = 15)
    private Float goal;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private CategoryEnum category;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 25)
    private Role role;


    public enum Role {
        ROLE_DESPESA("Despesa"),
        ROLE_RECEITA("Receita");

        private String label;
        private Role(String label) {
            this.label = label;
        }

        @JsonValue
        public String getLabel() {
            return label;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meta meta = (Meta) o;
        return Objects.equals(id, meta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Meta{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", description='" + description + '\'' +
                ", title=" + title +
                ", startDate=" + startDate +
                ", endDate='" + endDate + '\'' +
                ", goal='" + goal + '\'' +
                ", role=" + role +
                '}';
    }
}
