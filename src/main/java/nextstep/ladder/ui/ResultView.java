package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_NOTICE_COMMENT = "실행결과\n";
    private static final String RESULT_USER_NAME_FORMAT = "%5s ";
    private static final String RESULT_LADDER_OPEN = "-----|";
    private static final String RESULT_LADDER_CLOSE = "     |";

    public static void printResult(List<User> users, Ladder ladder) {
        System.out.println(RESULT_NOTICE_COMMENT);

        users.stream()
                .forEach(user -> System.out.print(String.format(RESULT_USER_NAME_FORMAT, user.getName())));

        System.out.print("\n");

        ladder.getLines().stream()
                .forEach(line -> System.out.println(getLineString(line)));
    }

    private static String getLineString(Line line) {
        List<String> lineShapes = line.getPoints().stream()
                .map(b -> b ? RESULT_LADDER_OPEN : RESULT_LADDER_CLOSE)
                .collect(Collectors.toList());
        return String.join("", lineShapes);
    }
}
