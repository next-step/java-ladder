package step2.view;


import static step2.view.ViewConstants.NEW_LINE;

import java.util.stream.Collectors;
import step2.domain.Ladder;
import step2.domain.LadderType;
import step2.domain.User;
import step2.domain.Users;

public class OutputView {

    public static void printResult() {
        System.out.println(Message.RESULT);
    }

    public static void printUsers(Users users) {
        String userToString = users.value().stream()
            .map(User::name)
            .map(name -> String.format("%6s", name.value()))
            .collect(Collectors.joining());
        System.out.println(userToString);
    }

    public static void printLadder(Ladder ladder) {
        String ladderToString = ladder.value().stream()
            .map(line -> line.points().stream()
                .map(LadderType::ladder)
                .collect(Collectors.joining()))
            .collect(Collectors.joining(NEW_LINE));
        System.out.println(ladderToString);
    }
}
