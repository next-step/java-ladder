import java.util.ArrayList;
import java.util.List;

public class LadderBuilder {
    private final RandomGenerator randomGenerator;

    public LadderBuilder(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public Ladder build(String[] players, int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            List<DotType> types = new ArrayList<>();

            boolean prevBridgeUsed = false;
            for (int j = 0; j < players.length; j++) {
                types.add(DotType.NODE);

                if (j != players.length - 1) {
                    DotType randType = this.randomGenerator.rand();

                    if (prevBridgeUsed || randType.is(DotType.EMPTY)) {
                        types.add(DotType.EMPTY);
                        prevBridgeUsed = false;
                        continue;
                    }

                    types.add(DotType.BRIDGE);
                    prevBridgeUsed = true;
                }
            }

            lines.add(new Line(i, types));
        }

        return new Ladder(players, lines);
    }
}
