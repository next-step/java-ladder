package nextstep.ladder.view;

import nextstep.ladder.model.*;

import java.util.stream.Collectors;

public class OutputView {

    private static final String BLANK_LINE = "     ";
    private static final String EXIST_LINE = "-----";
    private static final String LADDER_COLUMN = "|";
    private static final String DRAWING_NAME_FORMAT = "%5s";
    private static final String BLANK_DELIMITER = " ";

    private OutputView() {
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(Players players) {
        print(players.getPlayers().stream()
                .map(player -> String.format(DRAWING_NAME_FORMAT, player.getName()))
                .collect(Collectors.joining(BLANK_DELIMITER))
        );
    }

    public static void print(Line line) {
        print(BLANK_LINE + LADDER_COLUMN
                + line.getPoints().stream()
                .map(point -> point ? EXIST_LINE : BLANK_LINE)
                .collect(Collectors.joining(LADDER_COLUMN))
                + LADDER_COLUMN);
    }

    public static void print(Lines lines) {
        lines.getLines().forEach(OutputView::print);
    }

    public static void print(Results results) {
        print(results.getResults().stream()
                .map(result -> String.format(DRAWING_NAME_FORMAT, result.getName()))
                .collect(Collectors.joining(BLANK_DELIMITER))
        );
    }

    public static void print(Ladder ladder) {
        print("실행 결과");
        print(ladder.getPlayers());
        print(ladder.getLines());
        print(ladder.getResults());
    }
}
