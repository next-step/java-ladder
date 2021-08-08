package nextstep.ladder.view;

import nextstep.ladder.ladder.Ladder;
import nextstep.ladder.ladder.LadderLine;
import nextstep.ladder.ladder.LadderType;
import nextstep.ladder.ladder.Prizes;
import nextstep.ladder.ladder.dto.LadderResult;
import nextstep.ladder.player.Players;

public class ResultView {

    private static final String PRIZE_BLANK = "   ";
    private static final String NAME_BLANK = "  ";
    private static final String LADDER_BLANK = "    ";
    private static final String LADDER_DASH = "|";
    private static final String ESCAPE_CONDITION = "all";

    private ResultView() {
    }

    public static void printLadder(Players players, Ladder ladder, Prizes prizes) {
        System.out.println("사다리 결과");
        printPlayerName(players);
        printLadder(ladder);
        printPrize(prizes);
    }

    public static void printPlayerResult(LadderResult result, Players players, Prizes prizes) {
        String playerName = InputView.getInputPlayerResult();
        while (!ESCAPE_CONDITION.equals(playerName)) {
            int target = findPrizeTarget(result, players, playerName);
            System.out.println("실행 결과");
            System.out.println(prizes.findPrize(target));
            playerName = InputView.getInputPlayerResult();
        }
        printAllPlayerResult(result, players, prizes);
    }

    private static void printAllPlayerResult(LadderResult result, Players players, Prizes prizes) {
        players.getPlayers()
                .forEach(player -> {
                            String name = player.getName();
                    int target = findPrizeTarget(result, players, name);
                    System.out.println(name + ":" + prizes.findPrize(target));
                        }
                );
    }

    private static int findPrizeTarget(LadderResult result, Players players, String name) {
        int byNameIndex = players.findByName(name);
        return result.getTarget(byNameIndex);
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
                    System.out.println();
                });
    }

    private static void printLine(LadderLine line) {
        line.getPoints()
                .forEach(t -> {
                    LadderType type = LadderType.findByType(t.isMovable());
                    System.out.printf(LADDER_DASH + type.getLadder());
                });
    }

    private static void printPrize(Prizes prizes) {
        prizes.getPrizeNames()
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
