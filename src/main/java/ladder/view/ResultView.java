package ladder.view;

import ladder.config.NameConfig;

import java.util.List;

public class ResultView {
    private final static String RESULT_MESSAGE = "실행결과";
    private final static String LADDER_BLANK = " ";
    private final static int LADDER_PADDING = NameConfig.NAME_SIZE - 1;

    private ResultView() {
    }

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printUsers(List<String> users) {
        users.stream()
                .map(user -> String.format("%" + NameConfig.NAME_SIZE + "s ", user))
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printLadder(List<String> ladder) {
        ladder.stream()
                .map(line -> String.format("%-" + LADDER_PADDING + "s%s", LADDER_BLANK, line))
                .forEach(System.out::println);
    }
}
