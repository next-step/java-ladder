package step3.domain;

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
            while (lineLocation < lineSize) {
                PointStep pointStep = ladders.getLadderList().get(stepLocation).getLines().get(lineLocation).getPointStep();
                if (pointStep.equals(PointStep.RIGHT)) {
                    stepLocation++;
                }
                if (pointStep.equals(PointStep.LEFT)) {
                    stepLocation--;
                }
                if (pointStep.equals(PointStep.NONE)) {
                }
                lineLocation++;
            }
            result[i] = stepLocation;
        }
        return result;
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
            if (line.isCanStepable() && i != laddersCount) {
                line.setPointSetp(PointStep.RIGHT);
            }
            if (beforeLine.isCanStepable()) {
                line.setPointSetp(PointStep.LEFT);
            }
            if (!beforeLine.isCanStepable() && !line.isCanStepable()) {
                line.setPointSetp(PointStep.NONE);
            }
            if (beforeLine.isCanStepable() &&  !line.isCanStepable()) {
                line.setPointSetp(PointStep.LEFT);
            }
        }
    }

    private void markingFirstLineWithoutLeftDirection(int i, Ladder ladder) {
        for (int j = 0; j < ladder.getLineCount(); j++) {
            Line line = ladder.getLines().get(j);
            if (line.isCanStepable()) {
                line.setPointSetp(PointStep.RIGHT);
            }
            if (!line.isCanStepable()) {
                line.setPointSetp(PointStep.NONE);
            }
        }
    }


    public String[] calculateWinningPrizeLine(String[] winningPrize) {
        // calculate Point
        CalculateLadder calculateLadder = new CalculateLadder(ladders);
        int[] result = calculateLadder.calculte();
        // apply Prize Location
        String[] winningPrizeOrder = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            winningPrizeOrder[i] = winningPrize[result[i]];
        }
        return winningPrizeOrder;
    }

}
