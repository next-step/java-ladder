package nextstep.laddergame.view;

import nextstep.laddergame.domain.Gamer;
import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.LadderPiece;
import nextstep.laddergame.domain.Line;

public class ResultView {
    private static final String RESULT_STRING = "\n실행결과\n";
    private static final String NAME_SEPARATOR = " ";
    private static final String LADDER_PIECE = "|";
    private static final String NO_BRIDGE_STRING = "     ";
    private static final String BRIDGE_STRING = "-----";

    public static void printLadder(Ladder ladder) {
        System.out.println(RESULT_STRING);
        for (Gamer gamer : ladder.getGamers()) {
            System.out.print(gamer.getName() + NAME_SEPARATOR);
        }
        System.out.println();
        for (Line line : ladder.getBoard()) {
            printLine(line);
            System.out.println();
        }
    }

    private static void printLine(Line line) {
        for (LadderPiece ladderPiece : line.getLadderPieces()) {
            System.out.print(LADDER_PIECE);
            printBridgeString(ladderPiece);
        }
    }

    private static void printBridgeString(LadderPiece ladderPiece) {
        if (ladderPiece.isRightBridge()) {
            System.out.print(BRIDGE_STRING);
            return;
        }
        System.out.print(NO_BRIDGE_STRING);
    }
}
