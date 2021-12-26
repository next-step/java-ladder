package nextstep.ladder.view;

import java.util.stream.Collectors;

import nextstep.ladder.engine.GameResult;
import nextstep.ladder.engine.Ladder;
import nextstep.ladder.engine.Line;
import nextstep.ladder.engine.Name;
import nextstep.ladder.engine.Players;
import nextstep.ladder.engine.Prize;
import nextstep.ladder.engine.Prizes;

public class OutputView {
    public static final String NEWLINE = "\n";

    private static final String NAME_FORMAT = "%" + (Name.LENGTH_LIMIT + 1) + "s";
    private static final String SPACE = " ";
    private static final String LINE = "-";
    private static final String RAIL = "|";

    public static void printPlayerList(Players players) {
        players.stream()
                .map(OutputView::formatPadding)
                .forEach(System.out::print);
        System.out.print(NEWLINE);
    }

    public static String formatPadding(Object object) {
        return String.format(NAME_FORMAT, object);
    }

    public static String formatName(Name name) {
        return String.format(NAME_FORMAT, name);
    }

    public static String formatLine(Line line) {
        return SPACE.repeat(Name.LENGTH_LIMIT) + RAIL + mapLine(line);
    }

    public static String mapLine(Line line) {
        return line.boolStream()
                .map(OutputView::mapPoint)
                .collect(Collectors.joining(RAIL));
    }

    public static String mapPoint(boolean isPoint) {
        String point = isPoint ? LINE : SPACE;
        return point.repeat(Name.LENGTH_LIMIT);
    }

    public static void printResult(Prizes prizes) {
        prizes.stream()
                .map(OutputView::formatPadding)
                .forEach(System.out::print);
        System.out.print(NEWLINE);
    }

    public static void printLadder(Ladder ladder) {
        printPlayerList(ladder.players());

        ladder.stream()
                .map(OutputView::formatLine)
                .forEach(System.out::println);

        printResult(ladder.prizes());
    }

    public static void printResultOfPlayers(String nameOfUser, GameResult gameResult) {
        System.out.println("실행 결과");

        ResultPrinter resultPrinter = new ResultPrinter(nameOfUser, gameResult);
        gameResult.result(nameOfUser)
                .map(Prize::toString)
                .or(resultPrinter::mapNotExistUser)
                .ifPresent(System.out::println);
    }
}
