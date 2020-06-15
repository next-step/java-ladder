package nextstep.ladder.view;

import nextstep.ladder.domain.game.LadderGameResult;
import nextstep.ladder.domain.game.Result;
import nextstep.ladder.domain.ladder.Direction;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.user.User;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String EXECUTE_RESULT_MESSAGE = "실행 결과";

    private static String EMPTY_LINE = " ";
    private static String DEFAULT_LINE = "-";
    private static String DEFAULT_HEIGHT = "|";

    public static void printLadder(List<User> users, Ladder ladder) {
        System.out.println(LADDER_RESULT_MESSAGE + "\n");

        String userString = users.stream().map(User::getName)
                .collect(Collectors.joining(EMPTY_LINE));

        System.out.println(userString);
        ladder.getLines().forEach(line -> printLadderLine(line, ladder.getHeight()));
        System.out.println();
    }

    public static void printResult(LadderGameResult ladderGameResult) {
        System.out.println(EXECUTE_RESULT_MESSAGE);

        ladderGameResult.getUserResult().entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));

        System.out.println();
    }

    private static void printLadderLine(Line line, int height) {
        StringBuilder builder = new StringBuilder();
        line.getPositions().forEach(position -> {
            builder.append(DEFAULT_HEIGHT);
            String text = position.currentDirection().equals(Direction.RIGHT) ? DEFAULT_LINE : EMPTY_LINE;
            appendLine(builder, height, text);
        });
        System.out.println(builder.toString());
    }

    private static void appendLine(StringBuilder builder, int height, String text) {
        for (int i = 0; i < height; i++) {
            builder.append(text);
        }
    }
}
