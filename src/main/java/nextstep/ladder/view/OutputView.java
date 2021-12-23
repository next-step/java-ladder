package nextstep.ladder.view;

import java.util.Optional;
import java.util.stream.Collectors;

// todo view에서 LadderGame을 보면 안된다
import nextstep.ladder.LadderGame;
// todo domain을 너무 많이 본다
import nextstep.ladder.domain.PlayerName;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.ResultOfGame;
import nextstep.ladder.domain.Results;
// todo 최대한 engine만 보도록
import nextstep.ladder.engine.Ladder;
import nextstep.ladder.engine.Line;

public class OutputView {
    private static final String NAME_FORMAT = "%" + (PlayerName.LENGTH_LIMIT + 1) + "s";
    private static final String NEWLINE = "\n";
    private static final String SPACE = " ";
    private static final String LINE = "-";
    private static final String RAIL = "|";
    private static final String NAME_COLON = ":";

    public static void printPlayerList(Players players) {
        players.stream()
                .map(OutputView::formatPadding)
                .forEach(System.out::print);
        System.out.print(NEWLINE);
    }

    public static String formatPadding(Object object) {
        return String.format(NAME_FORMAT, object);
    }

    public static String formatName(PlayerName name) {
        return String.format(NAME_FORMAT, name);
    }

    public static String formatLine(Line line) {
        return SPACE.repeat(PlayerName.LENGTH_LIMIT) + RAIL + mapLine(line);
    }

    public static String mapLine(Line line) {
        return line.boolStream()
                .map(OutputView::mapPoint)
                .collect(Collectors.joining(RAIL));
    }

    public static String mapPoint(boolean isPoint) {
        String point = isPoint ? LINE : SPACE;
        return point.repeat(PlayerName.LENGTH_LIMIT);
    }

    public static void printResult(Results results) {
        results.stream()
                .map(OutputView::formatPadding)
                .forEach(System.out::print);
        System.out.print(NEWLINE);
    }

    public static void printLadder(Ladder ladder) {
        printPlayerList(ladder.players());

        ladder.stream()
                .map(OutputView::formatLine)
                .forEach(System.out::println);

        printResult(ladder.results());
    }

    public static void printResultOfPlayers(String nameOfUser, ResultOfGame resultOfGame) {
        System.out.println("실행 결과");

        resultOfGame.result(PlayerName.of(nameOfUser))
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
                .map(entry -> entry.getKey() + NAME_COLON + entry.getValue())
                .collect(Collectors.joining(NEWLINE));
    }
}
