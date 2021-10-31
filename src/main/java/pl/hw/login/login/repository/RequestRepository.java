package pl.hw.login.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hw.login.login.model.Request;

import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, String> {

    Optional<Request> findByLogin(String login);

}
