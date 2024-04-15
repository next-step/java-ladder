package ladder.view;

import ladder.model.Ladder;
import ladder.model.Line;

public class LadderDrawing {
    private static final String ONE_HEIGHT_OF_LADDER = "|";
    private static final String ONE_WIDTH_OF_LADDER = "-----";
    private static final String EMPTY_WIDTH_OF_LADDER = "     ";

    protected void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getHeightOfLadder(); i++) {
            printOneHeightOfLadder(ladder.getNthOfLadder(i));
            System.out.println();
        }
    }

    private void printOneHeightOfLadder(Line line) {
        for (int i = 0; i < line.getSizeOfLine(); i++) {
            System.out.printf(ONE_HEIGHT_OF_LADDER);
            connectLadder(line.isConnectedToNextLadder(i));
        }
    }

    private void connectLadder(boolean isConnected) {
        if (isConnected) {
            System.out.printf(ONE_WIDTH_OF_LADDER);
            return;
        }

        System.out.printf(EMPTY_WIDTH_OF_LADDER);
    }
}
