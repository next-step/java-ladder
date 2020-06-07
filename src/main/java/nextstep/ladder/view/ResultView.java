package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Direction;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Position;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String EXECUTE_RESULT_MESSAGE = "실행 결과";

    private static String EMPTY_LINE = " ";
    private static String DEFAULT_LINE = "-";
    private static String DEFAULT_HEIGHT = "|";

    public static void printResult(String users, Ladder ladder) {
        System.out.println(EXECUTE_RESULT_MESSAGE + "\n");
        System.out.println(users);
        ladder.getLines().forEach(line -> printLadderLine(line, ladder.getHeight()));
    }

    private static void printLadderLine(Line line, int height) {
        StringBuilder builder = new StringBuilder();
        line.getPositions().forEach(position -> {
            builder.append(DEFAULT_HEIGHT);
            String text = position.getDirection().equals(Direction.RIGHT) ? DEFAULT_LINE : EMPTY_LINE;
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
