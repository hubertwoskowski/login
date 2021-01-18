package pl.hw.login.login.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.hw.login.login.dto.GithubUserDTO;
import pl.hw.login.login.dto.UserDTO;
import pl.hw.login.login.repository.RequestRepository;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private RequestRepository requestRepository;

    public UserService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public UserDTO getUser(String login) {
        requestRepository.increment(login);
        Optional<GithubUserDTO> ghUser = getGithubUser(login);

        return ghUser.isPresent() ? new UserDTO(ghUser.get()) : null;
    }

    private Optional<GithubUserDTO> getGithubUser(String login) {

        final String uri = "https://api.github.com/users/" + login;

        RestTemplate restTemplate = new RestTemplate();
        GithubUserDTO ghUser;
        try {
            ghUser = restTemplate.getForObject(uri, GithubUserDTO.class);
        } catch (HttpClientErrorException.NotFound e){
            log.error("User {} not found on Github", login);
            ghUser = null;
        }

        return Optional.ofNullable(ghUser);
    }
}
