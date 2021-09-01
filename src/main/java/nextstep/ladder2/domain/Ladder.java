package nextstep.ladder2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Height height;
    private final List<LadderLine> ladderLines = new ArrayList<>();

    private Ladder(int height) {
        this.height = new Height(height);
    }

    public static Ladder of(int height, int countOfPerson) {
        Ladder ladder = new Ladder(height);
        ladder.createLadderBody(countOfPerson);
        return ladder;
    }

    public int getHeightValue() {
        return this.height.getValue();
    }

    public void createLadderBody(int countOfPerson) {
        for (int i = 0; i < height.getValue(); i++) {
            ladderLines.add(new LadderLine(countOfPerson));
        }
    }

    public int move(int startIndex) {
        for (int i = 0; i < height.getValue(); i++) {
            startIndex = ladderLines.get(i).move(startIndex);
        }
        return startIndex;
    }

    public LadderLine getLadderLine(int ladderLineIndex) {
        return ladderLines.get(ladderLineIndex);
    }
}
