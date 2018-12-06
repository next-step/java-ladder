package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private List<LadderLine> ladder;

    private Ladder(List<LadderLine> ladder) {
        this.ladder = ladder;
    }

    public static Ladder from(int depth, int length, LineStrategy ladderPointGenerator) {
        List<LadderLine> newLadder = new ArrayList<>();
        IntStream.range(0, depth).forEach(i -> newLadder.add(LadderLine.from(length).generatePoints(ladderPointGenerator)));
        return new Ladder(newLadder);
    }

    public String drawLadder() {
        String str = "";
        for(LadderLine line : ladder) {
            str += line.drawOrNot() + "\n";
        }
        return str;
    }

    public List<Integer> trackingLadder(int length) {
        ArrayList<Integer> tempBox = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            tempBox.add(i);
        }
        for(LadderLine ladderLine : ladder) {
            tempBox = new ArrayList<>(ladderLine.trackingLine(length, tempBox));
        }
        return tempBox;
    }

    public List<LadderLine> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
