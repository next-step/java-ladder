package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Row;
import nextstep.ladder.domain.ladder.Rung;
import nextstep.ladder.domain.player.Count;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.result.Results;

import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.view.MyPrinter.lineChange;
import static nextstep.ladder.view.MyPrinter.printLine;

public class OutputView {

    private OutputView() {}

    public static void printLadder(Players players, Ladder ladder, Results results) {
        printLine(Announcements.RESULT);

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

    private static String rungs(List<Rung> rungs, String emptyRungString, String rungString) {
        return rungs.stream()
                .map(rung -> {
                    if (rung.exist()) {
                        return Announcements.COLUMN + rungString;
                    }
                    return Announcements.COLUMN + emptyRungString;
                })
                .collect(Collectors.joining());
    }

    private static String spaceBuilder(int length) {
        return Announcements.SPACE.repeat(length);
    }

    private static String rungBuilder(int length) {
        return Announcements.RUNG.repeat(length);
    }

    private static abstract class Announcements {
        static final String RESULT = "실행결과";
        static final String SPACE = " ";
        static final String COLUMN = "|";
        static final String RUNG = "-";
    }
}
