package capstone.authapi.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import capstone.authapi.Models.AuthenticationModel;

@Repository
public interface AuthenticationRepository extends JpaRepository<AuthenticationModel, Long> {

    AuthenticationModel findByUsername(String username);

    AuthenticationModel findByEmail(String email);

}
