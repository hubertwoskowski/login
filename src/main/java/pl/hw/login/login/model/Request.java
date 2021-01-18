package pl.hw.login.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requests")
public class Request {

    @Id
    @Column(name="LOGIN")
    private String login;

    @Column(name="REQUEST_COUNT")
    private String request_count;

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getRequest_count() {
        return request_count;
    }

    public void setRequest_count(String request_count) {
        this.request_count = request_count;
    }
}
