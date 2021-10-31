package pl.hw.login.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.hw.login.login.dto.GithubUserDTO;
import pl.hw.login.login.dto.UserDTO;
import pl.hw.login.login.exception.CustomException;
import pl.hw.login.login.mapper.UserMapper;
import pl.hw.login.login.model.Request;
import pl.hw.login.login.repository.RequestRepository;
import pl.hw.login.login.util.Calculator;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final RequestRepository requestRepository;
    private final GithubUserService githubUserService;
    private final UserMapper userMapper;

    @Transactional
    public UserDTO getUser(String login) throws CustomException {
        Request request = requestRepository.findByLogin(login)
               .orElseGet(() -> requestRepository.save(new Request(login)));
        request.increment();

        GithubUserDTO ghUser = githubUserService.getGithubUser(login);

        UserDTO user = userMapper.mapToUserDTO(ghUser);
        user.setCalculations(Calculator.calculate(ghUser.getFollowers(), ghUser.getPublicRepos()));

        return user;
    }

}
