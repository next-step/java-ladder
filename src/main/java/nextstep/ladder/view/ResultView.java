package nextstep.ladder.view;

import nextstep.ladder.ladder.*;
import nextstep.ladder.player.Players;

import java.util.Arrays;

public class ResultView {

    private static final String PRIZE_BLANK = "   ";
    private static final String NAME_BLANK = "  ";
    private static final String LADDER_BLANK = "    ";
    private static final String LADDER_DASH = "|";
    private static final String ESCAPE_CONDITION = "all";

    private ResultView() {
    }


    public static void printLadder(LadderPrizes ladderPrizes, Ladder ladder) {
        Players players = ladderPrizes.getPlayers();
        players.play(ladder);
        System.out.println("사다리 결과");
        printPlayerName(players);
        printLadder(ladder);
        printPrize(ladderPrizes.getPrizes());
    }

    public static void printPlayerResult(LadderPrizes ladderPrizes) {
        String playerName = InputView.getInputPlayerResult();
        while (!ESCAPE_CONDITION.equals(playerName)) {
            String playerPrize = ladderPrizes.findPlayerPrize(playerName);
            System.out.println(playerPrize);
            playerName = InputView.getInputPlayerResult();
        }
        printAllPlayerResult(ladderPrizes, ladderPrizes.getPlayers());
    }

    private static void printAllPlayerResult(LadderPrizes ladderPrizes, Players players) {
        players.getPlayers()
                .forEach(player -> {
                            String name = player.getName();
                            System.out.println(name + ":" + ladderPrizes.findPlayerPrize(name));
                        }
                );
    }

    private static void printPlayerName(Players players) {
        players.getPlayers()
                .forEach(name -> System.out.printf(name.getName() + NAME_BLANK));
    }

    private static void printLadder(Ladder ladder) {
        System.out.println();
        ladder.getLines()
                .forEach(line -> {
                    System.out.printf(LADDER_BLANK);
                    printLine(line);
                    System.out.printf(LADDER_DASH);
                    System.out.println();
                });
    }

    private static void printLine(Line line) {
        line.getPoints()
                .forEach(t -> {
                    LadderType type = LadderType.findByType(t);
                    System.out.printf(LADDER_DASH + type.getLadder());
                });
    }

    private static void printPrize(Prizes prizes) {
        Arrays.stream(prizes.getPrizeNames())
                .forEach(name -> System.out.printf(name + getPrizeBlank(name)));
        System.out.println("\n");
    }

    private static String getPrizeBlank(String name) {
        if (name.length() == 1) {
            return LADDER_BLANK;
        }
        return PRIZE_BLANK;
    }
}
