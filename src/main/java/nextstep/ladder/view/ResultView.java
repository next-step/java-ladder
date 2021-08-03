package nextstep.ladder.view;

import nextstep.ladder.domain.dto.LadderFigure;
import nextstep.ladder.domain.dto.LadderResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.domain.player.Player.MAXIMUM_LENGTH_OF_NAME;

public class ResultView {
    private static final String RESULT_STATEMENT = "실행결과";
    private static final int EXTRA_PADDING = 1;
    private static final String NAME_FORMAT = "%" + (MAXIMUM_LENGTH_OF_NAME + EXTRA_PADDING) + "s";
    private static final String LINE_STRING = "-";
    private static final String BLANK_STRING = " ";
    private static final String PILLAR_STRING = "|";
    private static final String PADDING = makeMaxLengthStringWith(BLANK_STRING);
    private static final String PILLAR_WITH_LINE = PILLAR_STRING + makeMaxLengthStringWith(LINE_STRING);
    private static final String PILLAR_WITHOUT_LINE = PILLAR_STRING + makeMaxLengthStringWith(BLANK_STRING);

    private ResultView() {}

    public static void printResult(LadderResult result) {
        print(RESULT_STATEMENT);
        printNextLine();
        printPlayers(result.getPlayerNames());
        printLadder(result.getLadderFigures());
    }

    private static void printPlayers(List<String> playerNames) {
        printPlayer(playerNames);
        printNextLine();
    }

    private static void printPlayer(List<String> playerNames) {
        playerNames.stream()
                .map(name -> String.format(NAME_FORMAT, name))
                .forEach(ResultView::print);
    }

    private static void printLadder(List<LadderFigure> ladderFigures) {
        ladderFigures.forEach(ResultView::printLines);
    }

    private static void printLines(LadderFigure ladderFigure) {
        print(PADDING);
        printLine(ladderFigure);
        printNextLine();
    }

    private static void printLine(LadderFigure ladderFigure) {
        ladderFigure.getLines()
                .forEach(line -> print(line ? PILLAR_WITH_LINE : PILLAR_WITHOUT_LINE));
    }

    private static void print(String statement) {
        System.out.print(statement);
    }

    private static void printNextLine() {
        print(System.lineSeparator());
    }

    private static String makeMaxLengthStringWith(String value) {
        return Stream.generate(() -> value)
                .limit(MAXIMUM_LENGTH_OF_NAME)
                .collect(Collectors.joining());
    }
}
