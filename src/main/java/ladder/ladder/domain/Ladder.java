package ladder.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<LadderLine> ladder;

    private Ladder(List<LadderLine> ladder) {
        this.ladder = ladder;
    }

    public static Ladder init(int height, int countOfPerson) {
        List<LadderLine> generatedLadder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            generatedLadder.add(LadderLine.init(countOfPerson));
        }
        return new Ladder(generatedLadder);
    }

    public static Ladder of(List<LadderLine> ladder) {
        return new Ladder(ladder);
    }

    public Index move(Index index) {
        for (LadderLine line : ladder) {
            index = line.move(index);
        }
        return index;
    }

    public List<LadderLine> getLadder() {
        return new ArrayList<>(ladder);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "ladder=" + ladder +
                '}';
    }
}
