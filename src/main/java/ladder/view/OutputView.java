package ladder.view;

import ladder.model.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String WIDTH = "%6s";
    private static final String ALL = "all";

    public static void viewLadder(LadderGame ladderGame, List<Player> players, List<Prize> prizes) {
        viewPlayers(players);

        ladderGame.getLines().forEach(line -> {
            System.out.print(Ladder.LINE_ONLY.getShape());
            System.out.print(line);
            System.out.println();
        });

        viewPrizes(prizes);
    }

    public static void viewPlayers(List<Player> players) {
        System.out.println(players.stream()
                .map(player -> nameFormat(player.getName()))
                .collect(Collectors.joining()));
    }

    public static void particularPlayerPrize(LadderResult ladderResult, Player player) {
        Map<Player, Prize> resultMap = ladderResult.getResults();
        System.out.println(resultMap.get(player).getValue());
    }

    public static void getLadderResult(Player player, LadderResult ladderResult) {
        System.out.println("실행 결과");
        if (ALL.equals(player.getName())) {
            allLadderResult(ladderResult.getResults());
            return;
        }

        particularPlayerPrize(ladderResult, player);
    }

    public static void allLadderResult(Map<Player, Prize> results) {
        results.forEach((player, prize) -> System.out.println(player.getName() + " : " + prize.getValue()));
    }

    public static void viewPrizes(List<Prize> prizes) {
        System.out.println(prizes.stream()
                .map(prize -> nameFormat(prize.getValue()))
                .collect(Collectors.joining()));
    }

    private static StringBuilder nameFormat(String name) {
        return new StringBuilder().append(String.format(WIDTH, name));
    }
}
