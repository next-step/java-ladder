package ladder.dto;

import ladder.domain.User;

import java.util.List;

public class ResultDto {

    private final List<User> users;

    private final List<String> results;


    public ResultDto(List<User> users, List<String> results) {
        this.users = users;
        this.results = results;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<String> getResults() {
        return results;
    }
}
