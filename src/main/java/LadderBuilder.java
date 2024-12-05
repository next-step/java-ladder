import java.util.ArrayList;
import java.util.List;

public class LadderBuilder {
    private final RandomGenerator randomGenerator;
    private boolean prevBridgeUsed;

    public LadderBuilder(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        this.prevBridgeUsed = false;
    }

    public Ladder build(String[] players, String[] results, int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(buildLine(i, players.length));
        }

        return new Ladder(players, results, lines);
    }

    private Line buildLine(int lineNumber, int playerCount) {
        List<DotType> types = new ArrayList<>();

        this.prevBridgeUsed = false;

        for (int j = 0; j < playerCount - 1; j++) {
            types.add(DotType.NODE);
            types.add(buildBridgeDot());
        }

        types.add(DotType.NODE);

        return new Line(lineNumber, types);
    }

    private DotType buildBridgeDot() {
        DotType randType = this.randomGenerator.rand();

        if (this.prevBridgeUsed || randType.is(DotType.EMPTY)) {
            this.prevBridgeUsed = false;
            return DotType.EMPTY;
        }

        this.prevBridgeUsed = true;
        return DotType.BRIDGE;
    }
}
