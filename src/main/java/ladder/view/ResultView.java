package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLadderGenerationResult(List<User> users, Ladder ladder) {
        System.out.println("실행결과\n");
        printUserNames(users);
        printLadder(ladder);
    }

    public static void printUserNames(List<User> users) {
        System.out.println(
                users.stream()
                        .map(User::formatName)
                        .collect(Collectors.joining())
                        .trim()
        );
    }

    public static void printLadder(Ladder ladder) {
        ladder.printLadder();
    }
}
