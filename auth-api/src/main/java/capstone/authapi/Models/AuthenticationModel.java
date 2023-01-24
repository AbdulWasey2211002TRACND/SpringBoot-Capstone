package capstone.authapi.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Users")
@Entity
@Getter
@Setter
public class AuthenticationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    // columns
    private Long id;
    String username;
    String fullname;
    String password;
    String email;
    String dob;
    String role;
    Boolean is_active;

    // constructor
    public AuthenticationModel(Long id, String username, String fullname, String password, String email, String dob,
            String role, Boolean is_active) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.role = role;
        this.is_active = is_active;
    }

    public AuthenticationModel() {

    }

}
