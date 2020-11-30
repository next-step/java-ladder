package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.InputUsers;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    public void start() {
        InputView inputView = new InputView();

        InputUsers inputUsers = new InputUsers(inputView.inputParticipants());
        Users users = initUsers(inputUsers);

        Height height = new Height(Integer.parseInt(inputView.inputHeight()));
    }

    public Users initUsers(InputUsers inputUsers) {
        List<User> userList = Arrays.stream(inputUsers.splitUsers())
                .map(User::new)
                .collect(Collectors.toList());

        return new Users(userList);
    }
}
