    package com.example.demo.entity;

    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;
    import org.antlr.v4.runtime.misc.NotNull;
    import org.hibernate.annotations.IdGeneratorType;
    import org.springframework.lang.NonNull;
    @Getter
    @Setter
    @Entity
    @Table(name = "todo")
    public class TodoEntity {

        public TodoEntity() {
        }
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;
        private String title;
        private String todoDescription;

        private Boolean completed;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private UserEntity user;
    }
