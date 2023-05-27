package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderLine;
import ladder.domain.Player;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String START = "    |";
    private static final String LINE = "-----|";
    private static final String NO_LINE = "     |";

    public static void players(List<String> names) {
        System.out.println(String.join(",", names) + System.lineSeparator());
    }

    public static void result(Ladder ladder) {
        playersNameForResult(ladder.getPlayerNames());
        ladderResult(ladder.getLines());
    }

    private static void ladderResult(List<LadderLine> ladderLines) {
        ladderLines.forEach(line -> {
            System.out.print(START);
            line.getLines().forEach(hasLine -> System.out.print(hasLine ? LINE : NO_LINE));
            System.out.println();
        });
    }

    private static void playersNameForResult(List<String> names) {
        System.out.println(names.stream()
                .map(ResultView::alignName)
                .collect(Collectors.joining(" "))
        );
    }

    private static String alignName(String name) {
        int paddingLength = Math.max(1, Player.MAX_NAME_LENGTH - name.length());
        return " ".repeat(paddingLength) + name;
    }
}
