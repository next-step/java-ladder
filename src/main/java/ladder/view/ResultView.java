package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private final static String NAME_FORMAT = "%5s";
    private final static String LADDER_HEIGHT = "|";
    private final static String LADDER_LINE = "-----";
    private final static String LADDER_EMPTY = "     ";

    public static void resultLadderGame(List<User> users, Ladder ladder, Rewards rewards) {
        System.out.println("사다리 결과");
        System.out.println();

        printUserName(users);
        printLadder(ladder);
        printResult(rewards);
    }

    private static void printUserName(List<User> users) {
        users.stream()
                .map(User::getUserName)
                .forEach(name ->
                    System.out.print(String.format(NAME_FORMAT, name) + " "));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLadder()
                .stream()
                .map(ResultView::createLadder)
                .forEach(System.out::println);
    }

    private static String createLadder(Line line){
        return line.getLine()
                .stream()
                .map(isLine -> isLine ? LADDER_LINE : LADDER_EMPTY)
                .collect(Collectors.joining(LADDER_HEIGHT, "", LADDER_HEIGHT));
    }

    private static void printResult(Rewards rewards) {
        rewards.getRewards()
                .stream()
                .forEach(reward ->
                        System.out.print(String.format(NAME_FORMAT, reward.getReward()) + " "));
        System.out.println();
        System.out.println();
    }

    public static void printWhoGetPrize(String input, Result result) {
        System.out.println("실행 결과");
        if(input.equals("all")) {
            result.getResult()
                    .keySet()
                    .forEach(user ->
                            System.out.println(user.getUserName() + " : " + result.getIndividualResult(user)));
        }

        if(!input.equals("all")) {
            System.out.println(result.getIndividualResult(
                    result.getResult()
                            .keySet()
                            .stream()
                            .filter(user -> user.getUserName().equals(input))
                            .findFirst()
                            .get()));
        }
    }
}
