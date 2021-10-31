package pl.hw.login.login.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GithubUserDTO {
    private String login;
    private Integer id;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    private String type;
    private String name;
    @JsonProperty("public_repos")
    private Integer publicRepos;
    private Integer followers;
    @JsonProperty("created_at")
    private String createdAt;

}
