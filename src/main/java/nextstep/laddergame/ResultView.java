package nextstep.laddergame;

public class ResultView {
    public static void printLadder(Ladder ladder) {
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
