package nextstep.ladder;

import java.util.Arrays;

public class UsersInput {
    private final String input;

    public UsersInput(String input) {
        this.input = input;
    }

    public Users toUsers() {
        return new Users(Arrays.asList(input.replace(" ", "").split(",")));
    }
}
