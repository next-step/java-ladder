package nextstep.ladder.view;

import java.util.Optional;
import java.util.stream.Collectors;

// todo view에서 LadderGame을 보면 안된다
import nextstep.ladder.LadderGame;
import nextstep.ladder.engine.GameResult;
import nextstep.ladder.engine.Ladder;
import nextstep.ladder.engine.Line;
import nextstep.ladder.engine.Name;
import nextstep.ladder.engine.Players;
import nextstep.ladder.engine.Prize;
import nextstep.ladder.engine.Prizes;

public class OutputView {
    private static final String NAME_FORMAT = "%" + (Name.LENGTH_LIMIT + 1) + "s";
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

        gameResult.result(nameOfUser)
                .map(Prize::toString)
                .or(() -> mapNotExistUser(nameOfUser, gameResult))
                .ifPresent(System.out::println);
    }

    public static Optional<String> mapNotExistUser(String nameOfUser, GameResult resultOfGame) {
        return Optional.of(nameOfUser)
                .filter(name -> name.equalsIgnoreCase(LadderGame.ALL_COMMAND))
                .map(name -> parseAllResult(resultOfGame));
    }

    public static String parseAllResult(GameResult resultOfGame) {
        return resultOfGame.stream()
                .map(entry -> entry.getKey() + NAME_COLON + entry.getValue())
                .collect(Collectors.joining(NEWLINE));
    }
}
