package nextstep.ladder.view;

import java.util.Optional;
import java.util.stream.Collectors;

import nextstep.ladder.LadderGame;
import nextstep.ladder.domain.LadderFrame;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.ResultOfGame;
import nextstep.ladder.domain.Results;

public class OutputView {
    private static final String NAME_FORMAT = "%" + (Name.LENGTH_LIMIT + 1) + "s";
    private static final String NEWLINE = "\n";
    private static final String SPACE = " ";
    private static final String LINE = "-";
    private static final String RAIL = "|";
    private static final String NAME_COLON = ":";

    public static void printPlayerList(Players players) {
        players.stream()
                .map(Player::name)
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

    public static void printLadder(Ladder ladder) {
        ladder.stream()
                .map(OutputView::formatLine)
                .forEach(System.out::println);
    }

    public static String formatLine(Line line) {
        return SPACE.repeat(Name.LENGTH_LIMIT) + RAIL + mapLine(line) + RAIL;
    }

    public static String mapLine(Line line) {
        return line.stream()
                .map(OutputView::mapPoint)
                .collect(Collectors.joining(RAIL));

    }

    public static String mapPoint(boolean isPoint) {
        String point = isPoint ? LINE : SPACE;
        return point.repeat(Name.LENGTH_LIMIT);
    }

    public static void printResult(Results results) {
        results.stream()
                .map(OutputView::formatPadding)
                .forEach(System.out::print);
        System.out.print(NEWLINE);
    }

    public static void printLadder(LadderFrame ladderFrame, Ladder ladder) {
        printPlayerList(ladderFrame.players());
        printLadder(ladder);
        printResult(ladderFrame.results());
    }

    public static void printResultOfPlayers(String nameOfUser, ResultOfGame resultOfGame) {
        System.out.println("실행 결과");

        resultOfGame.result(Player.of(nameOfUser))
                .map(Result::toString)
                .or(() -> mapNotExistUser(nameOfUser, resultOfGame))
                .ifPresent(System.out::println);
    }

    public static Optional<String> mapNotExistUser(String nameOfUser, ResultOfGame resultOfGame) {
        return Optional.of(nameOfUser)
                .filter(name -> name.equalsIgnoreCase(LadderGame.ALL_COMMAND))
                .map(name -> parseAllResult(resultOfGame));
    }

    public static String parseAllResult(ResultOfGame resultOfGame) {
        return resultOfGame.streamOfEntry()
                .map(entry -> entry.getKey().name() + NAME_COLON + entry.getValue())
                .collect(Collectors.joining(NEWLINE));
    }
}
