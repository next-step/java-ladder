package view;

import domain.game.LaddersAndPrizes;
import domain.player.Players;
import domain.prize.Prizes;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    public static void viewLadders(Players players, LaddersAndPrizes laddersAndPrizes) {
        System.out.println("사다리 결과\n");
        System.out.println(players.beautify());
        System.out.println(laddersAndPrizes.beautify() + "\n");
    }

    public static void viewResults(Players players, Prizes prizes) {
        if (prizes.size() == 1) {
            System.out.println("실행 결과");
            System.out.println(prizes.beautify(0) + "\n");
            return;
        }

        final String playersMessage = IntStream.range(0, players.size())
                .mapToObj(i -> {
                    String prefix = players.beautify(i) + " : ";
                    return prizes.beautify(i, prefix);
                })
                .collect(Collectors.joining("\n"));

        System.out.println("실행 결과");
        System.out.println(playersMessage + "\n");
    }
}
