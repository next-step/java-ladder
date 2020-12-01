package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.InputUsers;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderController {

    private static final int ZERO = 0;

    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        InputUsers inputUsers = new InputUsers(inputView.inputParticipants());
        Users users = initUsers(inputUsers);

        Height height = new Height(Integer.parseInt(inputView.inputHeight()));

        resultView.printResultMention();
        printUsers(resultView, users);
        printLadders(resultView, height, users);
    }

    public Users initUsers(InputUsers inputUsers) {
        List<User> userList = Arrays.stream(inputUsers.splitUsers())
                .map(User::new)
                .collect(Collectors.toList());

        return new Users(userList);
    }

    private void printUsers(ResultView resultView, Users users) {
        users.getUsers()
                .forEach(user -> resultView.printUsers(user.getName()));
    }

    private void printLadders(ResultView resultView, Height height, Users users) {
        IntStream.range(ZERO, height.getHeight())
                .forEach(number -> printVertical(resultView, users));
    }

    private void printVertical(ResultView resultView, Users users) {
        System.out.println();
        IntStream.range(ZERO, users.getUsers().size())
                .forEach(number -> resultView.printVertical());
    }
}
