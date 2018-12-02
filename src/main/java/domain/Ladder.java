package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    List<Line> ladder;
    List<Integer> personsPosition = new ArrayList<>();

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public String drawOneLine() {
        String str = "";
        for(Line line : ladder) {
            str += line.drawOrNot() + "\n";
        }
        return str;
    }

    public static Ladder from(int depth, int length) {
        List<Line> newLadder = new ArrayList<>();
        IntStream.range(0, depth).forEach(i -> newLadder.add(Line.from(length)));
        return new Ladder(newLadder);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public List<Integer> followLadder() {
        for(Line line : ladder) {
            int dot = 0;
            personsPosition = line.processLining(dot, personsPosition);
        }
        return personsPosition;
    }

    public void initPosition(int countOfPerson) {
        IntStream.range(0, countOfPerson).forEach(i -> {
            personsPosition.add(i);
        });
    }
}
