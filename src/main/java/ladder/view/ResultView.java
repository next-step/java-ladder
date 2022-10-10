package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderResults;
import ladder.domain.Name;
import ladder.domain.Names;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final String LADDER_RESULT = "\n사다리 결과\n";
    private static final String WHITE_SPACE = " ";
    private static final String BAR = "|";
    private static final int BRIDGE_WIDTH = Name.MAX_LENGTH;
    private static final String BRIDGE = "-".repeat(BRIDGE_WIDTH);
    private static final String EMPTY_BRIDGE = WHITE_SPACE.repeat(BRIDGE_WIDTH);
    private static final String START_OF_LINE = WHITE_SPACE.repeat(BRIDGE_WIDTH - 1) + BAR;

    public static void printLadderResult(Names names, Ladder ladder, LadderResults ladderResults) {
        System.out.println(LADDER_RESULT);
        printNames(names);
        printLadder(ladder);
        printLadderResults(ladderResults);
    }

    private static void printNames(Names names) {
        String allNames = names.names()
                .stream()
                .map(name -> widthFormattedString(name.name()))
                .collect(joining(WHITE_SPACE));

        System.out.println(allNames);
    }

    private static void printLadder(Ladder ladder) {
        ladder.lines().forEach(line -> {
            String lineString = line.bridges()
                    .stream()
                    .map(ResultView::bridgeString)
                    .collect(joining(BAR, START_OF_LINE, BAR));
            System.out.println(lineString);
        });
    }

    private static void printLadderResults(LadderResults ladderResults) {
        String allLadderResults = ladderResults.ladderResults()
                .stream()
                .map(ladderResult -> widthFormattedString(ladderResult.ladderResult()))
                .collect(joining(WHITE_SPACE));

        System.out.println(allLadderResults);
    }

    private static String bridgeString(Boolean existsBridge) {
        if (existsBridge) {
            return BRIDGE;
        }

        return EMPTY_BRIDGE;
    }

    private static String widthFormattedString(String string) {
        return String.format("%" + BRIDGE_WIDTH + "s", string);
    }
}
