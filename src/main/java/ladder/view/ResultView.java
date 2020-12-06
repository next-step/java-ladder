package ladder.view;

import ladder.config.Config;

import java.util.List;

public class ResultView {
    private final static String RESULT_MESSAGE = "실행결과";
    private final static String LADDER_BLANK = " ";
    private final static int LADDER_PADDING = Config.NAME_SIZE - 1;

    private ResultView() {
    }

    public static void printReward(String rewards){
        System.out.println(rewards);
        System.out.println();
    }

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printNames(List<String> users) {
        users.stream()
                .map(user -> String.format("%" + Config.NAME_SIZE + "s ", user))
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printLadder(List<String> ladder) {
        ladder.stream()
                .map(line -> String.format("%-" + LADDER_PADDING + "s%s", LADDER_BLANK, line))
                .forEach(System.out::println);
    }
}
