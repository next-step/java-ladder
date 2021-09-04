package ladder;

import static ladder.view.InputView.inputUsernames;

import ladder.domain.application.UserService;
import ladder.domain.user.Users;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserService();
        Users users = userService.createUsers(inputUsernames());
    }

}
