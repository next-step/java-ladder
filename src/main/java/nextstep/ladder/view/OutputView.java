package nextstep.ladder.view;

import nextstep.ladder.model.*;

import java.util.Map;
import java.util.stream.Collectors;

import static nextstep.ladder.model.Line.BLANK_LINE;
import static nextstep.ladder.model.Line.LADDER_COLUMN;

public class OutputView {
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
                .map(Point::isActive)
                .map(Line::isLine)
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

    public static void print(Report report) {
        Map<String, Result> playerResults = report.getPlayerResults();
        playerResults.keySet().forEach(playerName -> {
            Result result = playerResults.get(playerName);
            print(String.format("%s : %s", playerName, result.getName()));
        });
    }

    public static void print(Report report, String name) {
        Result result = report.findResultByPlayerName(name);
        print(String.format("%s : %s", name, result.getName()));
    }
}
