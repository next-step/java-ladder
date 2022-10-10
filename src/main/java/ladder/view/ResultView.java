package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.Names;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final String INTRO = "\n실행 결과\n";
    private static final String NAMES_DELIMITER = " ";
    private static final String BAR = "|";
    private static final String BRIDGE = "-".repeat(Name.MAX_LENGTH);
    private static final String EMPTY_BRIDGE = " ".repeat(Name.MAX_LENGTH);
    private static final String START_OF_LINE = " ".repeat(Name.MAX_LENGTH - 1) + BAR;

    public static void printIntro() {
        System.out.println(INTRO);
    }

    public static void printNames(Names names) {
        String allNames = names.names()
                .stream()
                .map(ResultView::formattedName)
                .collect(joining(NAMES_DELIMITER));

        System.out.println(allNames);
    }

    public static void printLadder(Ladder ladder) {
        ladder.lines().forEach(line -> {
            String lineString = line.bridges()
                    .stream()
                    .map(ResultView::bridgeString)
                    .collect(joining(BAR, START_OF_LINE, BAR));
            System.out.println(lineString);
        });
    }

    private static String bridgeString(Boolean existsBridge) {
        if (existsBridge) {
            return BRIDGE;
        }

        return EMPTY_BRIDGE;
    }

    private static String formattedName(Name name) {
        return String.format("%" + Name.MAX_LENGTH + "s", name.name());
    }
}
