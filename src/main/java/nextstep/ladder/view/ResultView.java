package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.result.GameResult;
import nextstep.ladder.domain.result.LadderResult;
import nextstep.ladder.domain.result.LadderResults;

public class ResultView {

    public static void printLadder(Ladder ladder) {
        System.out.println();
        System.out.println("사다리결과");
        System.out.println();

        printPlayers(ladder.getPlayers());

        printLines(ladder.getLines());
    }

    private static void printPlayers(Players players) {
        players.getPlayers()
                .stream()
                .map(Player::getName)
                .forEach(name -> System.out.print(name + " "));

        System.out.println();
    }

    private static void printLines(Lines lines) {
        lines.getLines().forEach(System.out::println);
    }

    public static void printResults(LadderResults ladderResults) {
        ladderResults.getLadderResults()
                .forEach(ladderResult -> System.out.print(ladderResult + " "));

        System.out.println();
    }

    public static void printGameResult(GameResult gameResult, String playerName) {
        System.out.println();
        System.out.println("실행결과");

        if (playerName.equalsIgnoreCase("all")) {
            gameResult.getGameResults()
                    .forEach(ResultView::printGameResult);
        } else {
            printGameResult(gameResult.getResult(new Player(playerName)));
        }
    }

    private static void printGameResult(Player player, LadderResult ladderResult) {
        System.out.println(String.format("%s : %s", player.getName(), ladderResult.getLadderResult()));
    }

    private static void printGameResult(LadderResult ladderResult) {
        System.out.println(String.format("%s", ladderResult.getLadderResult()));
    }
}
