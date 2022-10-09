package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.Names;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final String INTRO = "\n실행 결과\n";
    private static final String NAMES_DELIMITER = " ";
    private static final String BAR = "|";
    private static final String HORIZONTAL_WAY = "-".repeat(Name.MAX_LENGTH);
    private static final String EMPTY_HORIZONTAL_WAY = " ".repeat(Name.MAX_LENGTH);
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
            String lineString = line.horizontalWays()
                    .stream()
                    .map(ResultView::horizontalWayString)
                    .collect(joining(BAR, START_OF_LINE, BAR));
            System.out.println(lineString);
        });
    }

    private static String horizontalWayString(Boolean existsHorizontalWay) {
        if (existsHorizontalWay) {
            return HORIZONTAL_WAY;
        }

        return EMPTY_HORIZONTAL_WAY;
    }

    private static String formattedName(Name name) {
        int nameLength = name.length();
        if (nameLength == Name.MAX_LENGTH) {
            return name.name();
        }

        return String.format("%s%s ", " ".repeat(Name.MAX_LENGTH - 1 - nameLength), name.name());
    }
}
