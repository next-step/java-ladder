package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LINE_SYMBOL_TRUE = "-----";
    private static final String LINE_SYMBOL_FALSE = "     ";

    public static void printLadderResult(Usernames usernames, Lines lines, List<String> results) {
        System.out.println(usernames.toString());
        System.out.println(lines.toString(LINE_SYMBOL_TRUE, LINE_SYMBOL_FALSE));
        System.out.println(String.join(
                "",
                results.stream()
                        .map(d -> String.format("%-6s", d))
                        .collect(Collectors.toList())
        ));
    }

}
