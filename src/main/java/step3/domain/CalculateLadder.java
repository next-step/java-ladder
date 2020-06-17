package step3.domain;

import java.util.Arrays;

public class CalculateLadder {

    private static Ladders ladders;
    private int[] winningPrizeOrder;

    private CalculateLadder() {
        // block
    }

    public CalculateLadder(Ladders ladders) {
        this.ladders = ladders;
        winningPrizeOrder = new int[ladders.getLadderList().size()];
    }

    public int[] calculte() {
        // int[x][y]
        int ladderSize = ladders.getLadderList().size();
        int lineSize = ladders.getLadderList().get(0).getLineCount();
        markingPointStep();
        int[] result = new int[ladderSize];
        int stepLocation = 0;
        int lineLocation = 0;
        for (int i = 0; i < ladderSize; i++) {
            stepLocation = i;
            lineLocation = 0;
            stepLocation = getStepLocation(lineSize, stepLocation, lineLocation);
            result[i] = stepLocation;
        }
        return result;
    }

    private int getStepLocation(int lineSize, int stepLocation, int lineLocation) {
        while (lineLocation < lineSize) {
            PointStep pointStep = ladders.getLadderList().get(stepLocation).getLines().get(lineLocation).getPointStep();
            stepLocation += getStepLocationLR(pointStep);
            lineLocation++;
        }
        return stepLocation;
    }

    private int getStepLocationLR(PointStep pointStep) {
        if (pointStep.equals(PointStep.RIGHT)) {
            return 1;
        }
        if (pointStep.equals(PointStep.LEFT)) {
            return -1;
        }
        return 0;
    }

    private void markingPointStep() {
        int laddersCount = ladders.getLadderList().size();

        for (int i = 0; i < laddersCount; i++) {
            Ladder ladder = ladders.getLadderList().get(i);
            if (i == 0) {
                markingFirstLineWithoutLeftDirection(i, ladder);
            }
            if (i >= 1) {
                Ladder beforeLadder = ladders.getLadderList().get(i - 1);
                markingLine(laddersCount, i, ladder, beforeLadder);
            }
        }
    }

    private void markingLine(int laddersCount, int i, Ladder ladder, Ladder beforeLadder) {
        for (int j = 0; j < ladder.getLineCount(); j++) {
            Line line = ladder.getLines().get(j);
            Line beforeLine = beforeLadder.getLines().get(j);
            if (i != laddersCount) {
                line.setPointSetp(PointStep.RIGHT, line.isCanStepable());
            }
            if (beforeLine.isCanStepable()) {
                line.setPointSetp(PointStep.LEFT);
            }
            if (!beforeLine.isCanStepable() && !line.isCanStepable()) {
                line.setPointSetp(PointStep.NONE);
            }
            if (beforeLine.isCanStepable() && !line.isCanStepable()) {
                line.setPointSetp(PointStep.LEFT);
            }
        }
    }

    private void markingFirstLineWithoutLeftDirection(int i, Ladder ladder) {
        for (int j = 0; j < ladder.getLineCount(); j++) {
            Line line = ladder.getLines().get(j);
            PointStep pointStep = line.isCanStepable() ? PointStep.RIGHT :
                    PointStep.NONE;
            line.setPointSetp(pointStep);
        }
    }

    public String[] calculateWinningPrizeLine(WinningPrizes winningPrizes) {
        // calculate Point
        CalculateLadder calculateLadder = new CalculateLadder(ladders);
        int[] result = calculateLadder.calculte();
        // apply Prize Location
        String[] winningPrizeOrder = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            winningPrizeOrder[i] = winningPrizes.get(result[i]);
        }
        return winningPrizeOrder;
    }

}
