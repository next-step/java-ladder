package ladder.view;

import ladder.domain.*;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final String LADDER_RESULT = "\n사다리 결과\n";
    private static final String EXECUTION_RESULT = "\n실행 결과";
    private static final String WHITE_SPACE = " ";
    private static final String BAR = "|";
    private static final int BRIDGE_WIDTH = Player.MAX_LENGTH;
    private static final String BRIDGE = "-".repeat(BRIDGE_WIDTH);
    private static final String EMPTY_BRIDGE = WHITE_SPACE.repeat(BRIDGE_WIDTH);
    private static final String START_OF_LINE = WHITE_SPACE.repeat(BRIDGE_WIDTH - 1) + BAR;

    public static void printLadderResult(Players players, Ladder ladder, LadderResults ladderResults) {
        System.out.println(LADDER_RESULT);
        printNames(players);
        printLadder(ladder);
        printLadderResults(ladderResults);
    }

    public static void printLadderResultsByPlayers(Players targetPlayers, Players resultPlayers, LadderResults ladderResults) {
        System.out.println(EXECUTION_RESULT);
        targetPlayers.players()
                .forEach(targetPlayer -> {
                    Player resultPlayer = resultPlayers.findByName(targetPlayer.name());
                    LadderResult ladderResult = ladderResults.ladderResultAt(resultPlayer.position());
                    System.out.println(String.format("%s : %s", targetPlayer.name(), ladderResult.ladderResult()));
                });
    }

    private static void printNames(Players players) {
        String allNames = players.players()
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
