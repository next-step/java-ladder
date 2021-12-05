package nextstep.ladder.view;

import java.util.stream.Collectors;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Players;

public class ResultView {

    private static final String NAME_FORMAT = "%6s";
    private static final String BLANK = "     ";
    private static final String LINE = "-----";
    private static final String DELIMITER = "|";

    private ResultView() {
    }

    public static void outputResult(Players players, Ladder ladder) {
        System.out.println("실행결과\n");
        outputPlayer(players);
        outputLadder(ladder);
    }

    private static void outputLadder(Ladder ladder) {
        ladder.getLadder()
            .stream()
            .map(line -> lineFormat(line))
            .forEach(System.out::println);
    }

    private static String lineFormat(Line line) {
        return BLANK + DELIMITER + line.getLine()
            .stream()
            .map(isLine -> lineOrBlank(isLine))
            .collect(Collectors.joining(DELIMITER)) + DELIMITER;
    }

    private static String lineOrBlank(Boolean isLine) {
        return isLine ? LINE : BLANK;
    }

    private static void outputPlayer(Players players) {
        String player = players.getPlayers().stream()
            .map((name -> String.format(NAME_FORMAT, name)))
            .collect(Collectors.joining());

        System.out.println(player);
    }

}
