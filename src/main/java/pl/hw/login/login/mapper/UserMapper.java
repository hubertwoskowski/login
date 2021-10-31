package pl.hw.login.login.mapper;

import org.mapstruct.Mapper;
import pl.hw.login.login.dto.GithubUserDTO;
import pl.hw.login.login.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO mapToUserDTO(GithubUserDTO githubUserDTO);

}
