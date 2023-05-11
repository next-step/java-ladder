package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.stream.Collectors;

public class OutputView {

    public static final String DEFAULT_LINE = "-----";
    public static final String DEFAULT_HEIGHT = "|";
    public static final String DEFAULT_SPACE_LINE = "     ";
    public static final String FIND_ALL_RESULT = "all";

    public static void endMessage() {
        System.out.println("사다리 결과");
    }

    public static void ladderResult(Members members, Ladder ladder) {
        String nameFormat = members.names().stream()
                                   .map(n -> String.format("%-5s", n))
                                   .collect(Collectors.joining(" "));
        System.out.println(nameFormat);
        printLadderView(ladder);
    }

    public static void runResult(Result result) {
        String resultFormat = result.results().stream()
                                    .map(r -> String.format("%-5s", r))
                                    .collect(Collectors.joining(" "));
        System.out.println(resultFormat);
    }

    private static void printLadderView(Ladder ladder) {
        ladder.lines().forEach(line -> System.out.println(convertLineView(line)));
    }

    private static String convertLineView(Line line) {
        String convertLine = line.points().stream()
                                 .map(p -> convertPoint(p.isRight()))
                                 .collect(Collectors.joining());

        return convertLine.trim();
    }

    private static String convertPoint(Boolean point) {
        return point ? DEFAULT_HEIGHT + DEFAULT_LINE : DEFAULT_HEIGHT + DEFAULT_SPACE_LINE;
    }

    public static void gameResult(ResultMatch result, Members members, String memberName) {
        System.out.println("실행 결과");
        if (FIND_ALL_RESULT.equals(memberName)) {
            members.names().forEach(n -> System.out.println(n + ":" + result.match(n)));
            return;
        }

        System.out.println(result.match(memberName));
    }
}
