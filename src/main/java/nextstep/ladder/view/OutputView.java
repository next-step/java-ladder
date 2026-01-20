package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Result;

import java.util.List;

public class OutputView {

    private static final int NAME_WIDTH = 6;

    public static void printPlayers(List<Player> players) {
        for (Player player : players) {
            System.out.printf("%" + NAME_WIDTH + "." + NAME_WIDTH + "s",
                    player.getName());
        }
        System.out.println();
    }

    public static void printLadder(List<Line> ladder) {
        for (Line line : ladder) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        System.out.print("    |");
        line.getPoints().forEach(
                point -> System.out.print(point ? "-----|" : "     |")
        );
        System.out.println();
    }

    public static void printResults(List<Result> results) {
        for (Result result : results) {
            System.out.printf("%" + NAME_WIDTH + "." + NAME_WIDTH + "s",
                    result.getValue());
        }
        System.out.println();
    }

    public static void printAllResults(LadderGame game) {
        List<Player> players = game.getPlayers();
        List<Result> results = game.playAll();
        for (int i = 0; i < players.size(); i++) {
            System.out.printf("%s : %s%n", players.get(i).getName(), results.get(i).getValue());
        }
    }

    public static void printResult(LadderGame game, String playerName) {
        Result result = game.play(playerName);
        System.out.println("실행 결과\n" + result.getValue());
    }
}
