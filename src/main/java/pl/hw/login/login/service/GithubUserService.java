package pl.hw.login.login.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.hw.login.login.dto.GithubUserDTO;
import pl.hw.login.login.exception.CustomException;

@Service
public class GithubUserService {

    public GithubUserDTO getGithubUser(String login) throws CustomException {
        final String uri = "https://api.github.com/users/" + login;

        RestTemplate restTemplate = new RestTemplate();
        GithubUserDTO ghUser;
        try {
            ghUser = restTemplate.getForObject(uri, GithubUserDTO.class);
        } catch (HttpClientErrorException.NotFound ex1) {
            throw new CustomException(String.format("User %s not found on Github!", login));
        } catch (HttpClientErrorException.Forbidden ex2) {
            throw new CustomException("Github API limit reached! Please try again some other time.");
        }

        return ghUser;
    }

}
