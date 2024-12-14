package nextstep.ladder;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static void printResult2(String resultUserName, Usernames usernames, Ladder2 ladder2, List<String> results) {
        Map<String, String> resultMap = allResult(usernames, ladder2, results);
        if ("all".equals(resultUserName.toLowerCase())) {
            String allResultStr = resultMap.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + " : " + entry.getValue())
                    .collect(Collectors.joining("\n"));
            System.out.println(allResultStr);
            return;
        }
        System.out.println(resultMap.get(resultUserName));
    }

    private static Map<String, String> allResult(Usernames usernames, Ladder2 ladder2, List<String> results) {
        Map<Integer, Integer> resultMap = ladder2.getAllResult();

        return IntStream.range(0, usernames.size()).boxed()
                .collect(Collectors.toMap(usernames::getUsername, i -> results.get(resultMap.get(i))));
    }

}
