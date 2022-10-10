package nextstep.laddergame.view;

import nextstep.laddergame.domain.Gamer;
import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.LadderPiece;
import nextstep.laddergame.domain.Line;

public class ResultView {
    public static void printLadder(Ladder ladder) {
        System.out.println("\n실행결과\n");
        for (Gamer gamer : ladder.getGamers()) {
            System.out.print(gamer.getName() + " ");
        }
        System.out.println();
        for (Line line : ladder.getBoard()) {
            printLine(line);
            System.out.println();
        }
    }

    private static void printLine(Line line) {
        for (LadderPiece ladderPiece : line.getLadderPieces()) {
            System.out.print("|");
            printBridgeString(ladderPiece);
        }
    }

    private static void printBridgeString(LadderPiece ladderPiece) {
        if (ladderPiece.isRightBridge()) {
            System.out.print("-----");
            return;
        }
        System.out.print("     ");
    }
}
