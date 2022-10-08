package ladder.view;

import ladder.domain.Ladder;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final String INTRO = "\n실행 결과\n";
    private static final String NAMES_DELIMITER = " ";
    private static final int FIXED_NAME_LENGTH = 5;
    private static final String BAR = "|";
    private static final String LINE = "-----";

    public static void printIntro() {
        System.out.println(INTRO);
    }

    public static void printNames(List<String> names) {
        String allNames = names.stream()
                .map(ResultView::fixedName)
                .collect(joining(NAMES_DELIMITER));

        System.out.println(allNames);
    }

    public static void printLadder(Ladder ladder) {
        ladder.lines().forEach(line -> {
            String lineString = line.lanes()
                    .stream()
                    .map(ResultView::laneString)
                    .collect(joining(BAR, " ".repeat(FIXED_NAME_LENGTH - 1) + BAR, BAR));
            System.out.println(lineString);
        });
    }

    private static String laneString(Boolean existsLane) {
        if (existsLane) {
            return LINE;
        }

        return " ".repeat(FIXED_NAME_LENGTH);
    }

    private static String fixedName(String name) {
        int nameLength = name.length();
        if (nameLength == FIXED_NAME_LENGTH) {
            return name;
        }

        return " ".repeat(FIXED_NAME_LENGTH - 1 - nameLength) + name + " ";
    }
}
