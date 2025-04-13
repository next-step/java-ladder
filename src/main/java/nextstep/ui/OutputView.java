package nextstep.ui;

import nextstep.ladder.Ladder;
import nextstep.ladder.Lines;
import nextstep.ladder.Players;

import java.util.stream.Collectors;

public class OutputView {

    public static void printResult(Ladder ladder) {
        System.out.println("실행 결과");
        printPlayer(ladder.getPlayers());
        printLine(ladder.getLines());
    }

    private static void printPlayer(Players players) {
        var playerNamesString = String.join("  ", players.getPlayersNames());
        System.out.println(playerNamesString);
    }

    private static void printLine(Lines lines) {
        lines.getLines().forEach(line -> {
            String lineString = line.getPoints().stream()
                    .map(point -> point ? "-----" : "     ")
                    .collect(Collectors.joining("|", "|", "|"));
            System.out.println(lineString);
        });
    }
}
