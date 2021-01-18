package pl.hw.login.login.dto;

public class UserDTO {
    private Integer id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;
    private Double calculations;

    public UserDTO(GithubUserDTO ghUser) {
        this.id = ghUser.getId();
        this.login = ghUser.getLogin();
        this.name = ghUser.getName();
        this.type = ghUser.getType();
        this.avatarUrl = ghUser.getAvatar_url();
        this.createdAt = ghUser.getCreated_at();
        this.calculations = ghUser.getFollowers() != 0 ? 6.0 / ghUser.getFollowers() * (2.0 + ghUser.getPublic_repos()) : null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Double getCalculations() {
        return calculations;
    }

    public void setCalculations(Double calculations) {
        this.calculations = calculations;
    }
}
