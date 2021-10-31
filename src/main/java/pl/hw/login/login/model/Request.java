package pl.hw.login.login.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "requests")
public class Request {

    @Id
    @Column(name="LOGIN")
    private String login;

    @Column(name="REQUEST_COUNT")
    private Integer requestCount = 0;

    public Request(String login){
        this.login = login;
    }

    public void increment(){
        this.requestCount++;
    }

}
