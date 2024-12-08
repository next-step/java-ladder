import java.util.ArrayList;
import java.util.List;

public class LadderBuilder {
    private final RandomGenerator randomGenerator;

    public LadderBuilder(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public Ladder build(String[] playerNames, String[] resultNames, int height) {
        List<List<Boolean>> rands = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            rands.add(genRandLine(playerNames.length));
        }

        return this.build(playerNames, resultNames, rands);
    }

    public Ladder build(String[] playerNames, String[] resultNames, List<List<Boolean>> rands) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < rands.size(); i++) {
            lines.add(new Line(i, rands.get(i)));
        }

        return new Ladder(lines, playerNames, resultNames);
    }

    private List<Boolean> genRandLine(int playerNum) {
        List<Boolean> randLine = new ArrayList<>();

        boolean prevRand = false;
        for (int j = 0; j < playerNum - 1; j++) {
            prevRand = genRand(prevRand, randLine);
        }
//        randLine.add(false);

        return randLine;
    }

    private boolean genRand(boolean prevRand, List<Boolean> randLine) {
        boolean rand = prevRand ? false : this.randomGenerator.rand();

        randLine.add(rand);

        return rand;
    }
}
