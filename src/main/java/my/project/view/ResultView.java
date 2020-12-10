package my.project.view;

import my.project.domain.Ladder;
import my.project.domain.Reward;
import my.project.domain.Symbol;
import my.project.domain.User;
import my.project.dto.Result;
import my.project.domain.Rewards;
import my.project.domain.Users;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static final String TITLE = "\n사다리 결과\n";
    public static final String DELIMITER = " ";
    public static final String REWARD_TITLE = "\n실행 결과";

    private ResultView() {
    }

    public static void print(Users users, Ladder ladder, Rewards rewards) {
        printTitle();
        printUsers(users);
        printLadder(ladder);
        printRewards(rewards);
    }

    private static void printTitle() {
        System.out.println(TITLE);
    }

    private static void printUsers(Users users) {
        System.out.println(users.getUsers().stream()
                .map(User::getName)
                .collect(Collectors.joining(DELIMITER)));
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines().get()
                .forEach(line -> System.out.println(
                        line.getPoints().stream()
                                .map(Symbol::getSymbol)
                                .collect(Collectors.joining())
                        )
                );
    }

    private static void printRewards(Rewards rewards) {
        System.out.println(rewards.getRewards().stream()
                .map(Reward::get)
                .collect(Collectors.joining(DELIMITER)));
    }

    public static void printResults(List<Result> results) {
        System.out.println(REWARD_TITLE);
        results.stream()
                .forEach(result -> System.out.println(result.getUsername() + " : " + result.getReward()));
    }
}
