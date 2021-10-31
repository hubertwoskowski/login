package pl.hw.login.login.util;

public class Calculator {

    public static Double calculate(Integer followers, Integer publicRepos){
        return followers != 0 ? 6.0 / followers * (2.0 + publicRepos) : null;
    }

}
