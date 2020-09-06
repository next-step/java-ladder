package ladder.view;

import ladder.domain.*;

import java.io.PrintWriter;

public class OutputView {
    private static final String BLANK = "       ";
    private static final String BRIDGE = "-------";
    private static final String POINT = "|";

    private final PrintWriter writer;

    private OutputView() {
        this.writer = new PrintWriter(System.out, true);
    }

    private static class InnerHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return InnerHolder.INSTANCE;
    }

    public void printLadderGame(LadderGame game) {
        writer.println(OutputViewMessage.RESULT_START.getMessage());

        printParticipants(game.getParticipants());
        printLadder(game.getLadder());

        writer.printf("\n");
    }

    private void printParticipants(Participants participants) {
        writer.println(participants.toString());
    }

    public void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            line.getPoints()
                    .forEach(this::printPoint);
            writer.printf("\n");
        }
    }

    public void printPoint(Point point) {
        writer.printf(POINT);
        if (point.getRight()) {
            writer.printf(BRIDGE);
            return;
        }
        writer.printf(BLANK);
    }
}
