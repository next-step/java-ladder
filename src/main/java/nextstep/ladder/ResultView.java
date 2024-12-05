package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LINE_SYMBOL_TRUE = "-----";
    private static final String LINE_SYMBOL_FALSE = "     ";

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.getLadderForPrint(LINE_SYMBOL_TRUE, LINE_SYMBOL_FALSE));
    }

    public static void printLadder2(Ladder2 ladder) {
        System.out.println(ladder.getLadderForPrint(LINE_SYMBOL_TRUE, LINE_SYMBOL_FALSE));
    }

    public static void printUsernames(Usernames usernames) {
        System.out.println(usernames.getUsernamesForPrint());
    }

    public static void printResults(List<String> results) {
        String resultStr = results.stream()
                .map(d -> String.format("%-6s", d))
                .collect(Collectors.joining());

        System.out.println(resultStr);
    }

    public static void printResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

}
