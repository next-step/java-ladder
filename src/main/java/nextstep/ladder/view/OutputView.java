package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Rung;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Row;
import nextstep.ladder.domain.player.Count;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.result.GameResults;
import nextstep.ladder.domain.result.Result;
import nextstep.ladder.domain.result.Results;

import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.view.MyPrinter.lineChange;
import static nextstep.ladder.view.MyPrinter.printLine;

public class OutputView {

    private OutputView() {}

    public static void printLadder(Players players, Ladder ladder, Results results) {
        printLine(Announcements.LADDER_SHAPE);

        lineChange();

        final int columnWidth = columnWidth(players, results);
        printPlayers(players, columnWidth);
        printLadder(ladder, columnWidth);
        printResults(results, columnWidth);

        lineChange();
    }

    private static int columnWidth(Players players, Results results) {
        final Count maxLength = players.maxNameLength().max(results.maxValueLength());
        return (maxLength.value() / 2 + 1) * 2 + 1;
    }

    private static void printPlayers(Players players, int columnWidth) {
        printLine(centerAlignAndJoinStrings(players.playerNames(), columnWidth));
    }

    private static void printResults(Results results, int columnWidth) {
        printLine(centerAlignAndJoinStrings(results.resultNames(), columnWidth));
    }

    private static String centerAlignAndJoinStrings(List<String> names, int columnWidth) {
        return names.stream()
                .map(name -> centerName(name, columnWidth))
                .collect(Collectors.joining());
    }

    private static String centerName(String name, int width) {
        int rightPad = (width - name.length()) / 2;
        int leftPad = width - name.length() - rightPad;

        return spaceBuilder(leftPad) + name + spaceBuilder(rightPad);
    }

    private static void printLadder(Ladder ladder, int columnWidth) {
        ladder.rows().forEach(row -> printLadderRow(row, columnWidth));
    }

    private static void printLadderRow(Row ladderRow, int columnWidth) {
        final String leftPad = spaceBuilder(columnWidth / 2);
        final String emptyRungString = spaceBuilder(columnWidth - 1);
        final String rungString = rungBuilder(columnWidth - 1);

        String rowString = leftPad +
                rungs(ladderRow.rungs(), emptyRungString, rungString) +
                Announcements.COLUMN;

        printLine(rowString);
    }

    private static String rungs(List<Rung> connections, String emptyRungString, String rungString) {
        return connections.stream()
                .map(rung -> {
                    if (rung.isRight()) {
                        return Announcements.COLUMN + rungString;
                    }
                    return Announcements.COLUMN + emptyRungString;
                })
                .limit(connections.size() - 1)
                .collect(Collectors.joining());
    }

    public static void gameResults(GameResults gameResults, Players targetPlayers) {
        printLine(Announcements.RESULT);

        if (targetPlayers.count().equals(1)) {
            singleResult(gameResults, targetPlayers);
            return;
        }
        allResults(gameResults, targetPlayers);
    }

    private static void singleResult(GameResults gameResults, Players targetPlayers) {
        final Result result = gameResults.findBy(targetPlayers.values().get(0));
        printLine(result.value() + "\n");
    }

    private static void allResults(GameResults gameResults, Players players) {
        players.values().forEach(player -> {
            final Result result = gameResults.findBy(player);
            printLine(String.format(Announcements.PLAYER_RESULT_FORMAT, player.name().value(), result.value()));
        });
    }

    private static String spaceBuilder(int length) {
        return Announcements.SPACE.repeat(length);
    }

    private static String rungBuilder(int length) {
        return Announcements.RUNG.repeat(length);
    }

    private static abstract class Announcements {
        static final String LADDER_SHAPE = "사다리결과";
        static final String SPACE = " ";
        static final String COLUMN = "|";
        static final String RUNG = "-";

        static final String RESULT = "실행결과";
        static final String PLAYER_RESULT_FORMAT = "%s : %s";
    }
}
