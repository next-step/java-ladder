package nextstep.ladder.view;

import nextstep.ladder.ladder.Ladder;
import nextstep.ladder.ladder.LadderType;
import nextstep.ladder.player.Players;

public class ResultView {

    private static final String NAME_BLANK = "  ";
    private static final String LADDER_BLANK = "    ";
    private static final String LADDER_DASH = "|";

    private ResultView() {
    }


    public static void print(Players players, Ladder ladder) {
        System.out.println("실행결과");
        printPlayerName(players);
        printLadder(ladder);
    }

    private static void printPlayerName(Players players) {
        players.getPlayers()
                .forEach((name) -> System.out.printf(name.getName() + NAME_BLANK));
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

    private static void printLine(nextstep.ladder.ladder.Line line) {
        line.getPoints()
                .forEach((t) -> {
                    LadderType type = LadderType.findByType(t);
                    System.out.printf(LADDER_DASH + type.getLadder());
                });
    }
}
