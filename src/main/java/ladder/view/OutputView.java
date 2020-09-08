package ladder.view;

import ladder.domain.*;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

public class OutputView {
    private static final String ALL = "all";
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

    public void printLadderGame(LadderGame game, Rewards rewards) {
        writer.println(OutputViewMessage.RESULT_LADDER.getMessage());

        printParticipants(game.getParticipants());
        printLadder(game.getLadder());

        printRewards(rewards);
    }

    private void printRewards(Rewards rewards) {
        writer.println(rewards.toString());
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

    public void printGameResult(Name target, LadderResult result, Rewards rewards) {
        System.out.println(OutputViewMessage.RESULT_START.getMessage());

        if (!target.equals(ALL)) {
            int position = result.findResultByName(target);
            writer.println(target + " : " + rewards.getRewardByPosition(position));
            return;
        }

        for (Name name : result.getAllNames()) {
            int position = result.findResultByName(name);
            writer.println(name + " : " + rewards.getRewardByPosition(position));
        }
    }
}
