package step3.view;

import step3.model.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String WIDTH = "%6s";

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

    public static void viewResult(Result result) {
        Map<String, Prize> resultMap = result.getResult();
        resultMap.keySet().forEach(name -> {
            System.out.println(name + " : " + resultMap.get(name).getValue());
        });
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
