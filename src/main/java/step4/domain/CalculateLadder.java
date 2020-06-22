package step4.domain;

public class CalculateLadder {

    private Ladders ladders;

    private CalculateLadder() {
        // block
    }

    public CalculateLadder(Ladders ladders) {
        this.ladders = ladders;
    }

    public int[] calculte() {
        // int[x][y]
        int ladderSize = ladders.getSize();
        int lineSize = ladders.getLineSize();
        ladders.markingPointStep();
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
            stepLocation += pointStep.getStepLocationLR();
            lineLocation++;
        }
        return stepLocation;
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
