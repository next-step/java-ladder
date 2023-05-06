package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Member;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String DEFAULT_LINE = "-----";
    public static final String DEFAULT_HEIGHT = "|";
    public static final String DEFAULT_SPACE_LINE = "     ";

    public static void endMessage() {
        System.out.println("실행 결과");
    }

    public static void gameResult(List<Member> members, Ladder ladder) {
        String nameFormat = members.stream()
                                   .map(Member::name)
                                   .collect(Collectors.joining(" "));
        System.out.println(nameFormat);
        printLadderView(ladder);
    }

    private static void printLadderView(Ladder ladder) {
        ladder.lines().forEach(line -> System.out.println(convertLineView(line)));
    }

    private static String convertLineView(Line line) {
        String convertLine = line.points().stream()
                                 .map(p -> convertPoint(p.isRight()))
                                 .collect(Collectors.joining());

        return DEFAULT_HEIGHT + convertLine;
    }

    private static String convertPoint(Boolean point) {
        return point ? DEFAULT_LINE + DEFAULT_HEIGHT : DEFAULT_SPACE_LINE + DEFAULT_HEIGHT;
    }

}
