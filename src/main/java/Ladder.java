import java.util.Arrays;
import java.util.List;

public class Ladder {
    private final List<String> players;
    private final List<Line> lines;

    public Ladder(String[] playerNames, List<Line> lines) {
        this.players = Arrays.asList(playerNames);
        this.lines = lines;
    }

    public int height() {
        return this.lines.size();
    }

    public long playerCount() {
        return this.lines.get(0).nodeCount();
    }

    public int travel(int playerNumber) {
//        StepResult stepResult = new StepResult(new Dot(playerNumber * 2, 0, DotType.NODE), true);
        StepResult stepResult = new StepResult(DotCache.get(playerNumber * 2, 0), true);

        while (stepResult.lowerHeightThan(height())) {
            stepResult = moveStep(stepResult);
        }

        return stepResult.playerNumber();
    }

    private StepResult moveStep(StepResult stepResult) {
        Dot curDot = stepResult.getCurDot();

        if (availLeft(curDot) && stepResult.getHorizontalMovable()) {
            return stepResult.refresh(curDot.moveLeft(), false);
        }

        if (availRight(curDot) && stepResult.getHorizontalMovable()) {
            return stepResult.refresh(curDot.moveRight(), false);
        }

        return stepResult.refresh(curDot.moveDown(), true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;

        return this.lines.equals(ladder.lines);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(String playerName : players) {
            sb.append(Constants.PADDING);
            sb.append(playerName);
            for(int i = 0; i < 5 - playerName.length(); i++) {
                sb.append(" ");
            }
        }

        sb.append("\n");

        for (Line line : lines) {
            sb.append(line.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    private boolean availRight(Dot curDot) {
        Line line = this.lines.get(curDot.getY());

        if (curDot.getX() == line.size() - 1) {
            return false;
        }

        return line.isBridge(curDot.getX() + 1);
    }

    private boolean availLeft(Dot curDot) {
        Line line = this.lines.get(curDot.getY());

        if (curDot.getX() == 0) {
            return false;
        }

        return line.isBridge(curDot.getX() - 1);
    }
}
