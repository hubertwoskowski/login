package pl.hw.login.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.hw.login.login.model.Request;

import javax.transaction.Transactional;

@Repository
public interface RequestRepository extends JpaRepository<Request, String> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Requests(login, request_count) VALUES(:login, 1) ON DUPLICATE KEY UPDATE request_count = request_count + 1"
            , nativeQuery = true)
    void increment(String login);
}
