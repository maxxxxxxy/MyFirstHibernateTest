package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import java.util.Objects;

@Getter
@Setter
@Table(name = "users",schema = "public",catalog = "postgres")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    private String username;





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(name, users.name) && Objects.equals(lastname, users.lastname) && Objects.equals(username, users.username) && Objects.equals(id, users.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, username, id);
    }
}
