package ladder.service;

import ladder.domain.Users;
import ladder.view.InputView;

public class LadderService {
    private Users users;

    public void createUsers() {
        users = InputView.inputUserName();
        System.out.println(users);
    }
}
