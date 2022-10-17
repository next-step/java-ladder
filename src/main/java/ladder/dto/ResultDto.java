package ladder.dto;

import ladder.domain.User;

public class ResultDto {

    private final User user;

    private final String result;

    public ResultDto(User user, String result) {
        this.user = user;
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public String getResult() {
        return result;
    }
}
