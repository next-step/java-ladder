package laddergameRDD.view;

import laddergameRDD.domain.*;
import laddergame.domain.user.Name;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static laddergame.domain.user.Name.MAX_NAME_LENGTH;

public class OutputView {
    public static final String LADDER_WITH_HORIZONTAL_LINE = "-----|";
    public static final String LADDER_WITHOUT_HORIZONTAL_LINE = "     |";

    public static void printGameMap(List<String> userNames, List<String> results, Ladder ladder) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println(makeListToString(userNames));
        ladder.getLadder().stream()
                .map(row -> makeRowString(row))
                .forEach(System.out::println);
        System.out.println(makeListToString(results));
        System.out.println();
    }

    private static String makeListToString(List<String> userNames) {
        return userNames.stream()
                .map(name -> " ".repeat(1 + MAX_NAME_LENGTH - name.length()) + name)
                .collect(Collectors.joining());
    }

    private static String makeRowString(Row row) {
        return row.getRow().stream()
                .map(point -> {
                    if (point) {
                        return LADDER_WITH_HORIZONTAL_LINE;
                    }
                    return LADDER_WITHOUT_HORIZONTAL_LINE;
                })
                .collect(Collectors.joining());
    }

    public static void printResult(List<GameResult> gameResult, String target) {
        System.out.println();
        System.out.println("실행 결과");
        if (target.equals("all")) {
            printEveryResult(gameResult);
            return;
        }
        GameResult result = gameResult.stream()
                .filter(g -> g.getUserName().equals(target))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 참여자는 존재하지 않습니다."));
        System.out.println(target + " : " + result.getResult());
        System.out.println();
    }

    private static void printEveryResult(List<GameResult> totalGameResult) {
        for (GameResult gameResult: totalGameResult) {
            System.out.println(gameResult.getUserName() + " : " + gameResult.getResult());
        }
        System.out.println();
    }
}
