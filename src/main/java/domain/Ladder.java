package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private List<LadderLine> ladder;
    private List<Integer> personsPosition;

    private Ladder(List<LadderLine> ladder, List<Integer> personsPosition) {
        this.ladder = ladder;
        this.personsPosition = personsPosition;
    }

    public static Ladder from(int depth, int length) {
        List<LadderLine> newLadder = new ArrayList<>();
        List<Integer> personsPosition = new ArrayList<>();
        IntStream.range(0, depth).forEach(i -> newLadder.add(LadderLine.from(length)));
        IntStream.range(0, length).forEach(i -> personsPosition.add(i));
        return new Ladder(newLadder, personsPosition);
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
            tempBox = new ArrayList<>(ladderLine.trackingLine(personsPosition, length, tempBox));
        }
        return tempBox;
    }

    public List<LadderLine> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public List<Integer> getPersonsPosition() {
        return Collections.unmodifiableList(personsPosition);
    }
}
