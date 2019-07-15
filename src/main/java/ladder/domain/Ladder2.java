package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// Step4 에서 사용하는 Ladder (LadderLine 이용)
public class Ladder2 {
    private List<LadderLine> ladderLines;

    private Ladder2() {
        this.ladderLines = new ArrayList<>();
    }

    public static Ladder2 of(int height, int ladderSize) {
        Ladder2 ladder2 = new Ladder2();
        IntStream.range(0, height)
                .forEach((i) -> ladder2.addLadderLine(ladderSize));
        return ladder2;
    }

    public int height() {
        return ladderLines.size();
    }

    public int move(int index) {
        return ladderLines.get(0).move(index);
    }

    public LadderLine getLadderLineByLevel(int level) {
        return ladderLines.get(level);
    }

    private void addLadderLine(int ladderSize) {
        ladderLines.add(LadderLine.init(ladderSize));
    }
}
