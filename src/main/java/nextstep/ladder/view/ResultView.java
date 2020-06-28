package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-----";
    private static final String NON_HORIZONTAL = "     ";
    private static final String LADDER_TITLE = "사다리 결과";
    private static final String COMMAND_ALL = "all";
    private static final String RESULT_TITLE = "실행결과\n";
    private static final String INVALID_USER_NAME = "all 혹은 게임에 참여하는 사람만 조회할 수 있습니다.";

    public void printUserNames(List<String> userNames) {
        userNames.forEach(userName -> System.out.printf("%-6s", userName));
        System.out.println();
    }

    private void printLadder(List<List<Boolean>> ladder) {
        ladder.forEach(this::printHorizontalLine);
    }

    private void printHorizontalLine(List<Boolean> line) {
        line.forEach(point -> {
            System.out.print(VERTICAL);
            printHorizontal(point);
        });
        System.out.println(VERTICAL);
    }

    private void printHorizontal(Boolean hasLadder) {
        if (hasLadder) {
            System.out.print(HORIZONTAL);
            return;
        }
        System.out.print(NON_HORIZONTAL);
    }

    public void printLadder(List<String> userNames, List<List<Boolean>> ladder, String[] results) {
        printTitle();
        printUserNames(userNames);
        printLadder(ladder);
        printResults(results);
    }

    private void printTitle() {
        System.out.println();
        System.out.println(LADDER_TITLE);
        System.out.println();
    }

    private void printResults(String[] results) {
        Arrays.stream(results)
            .forEach(result -> System.out.printf("%-6s", result));
        System.out.println();
    }

    public void printResult(Map<String, String> resultMap, String resultUser) {
        System.out.print(RESULT_TITLE);
        if (resultUser.equals(COMMAND_ALL)) {
            resultMap.forEach((userName, result) -> System.out.println(userName + " : " + result));
            return;
        }
        if (resultMap.get(resultUser) == null) {
            throw new IllegalArgumentException(INVALID_USER_NAME);
        }
        System.out.println(resultMap.get(resultUser));
    }
}
