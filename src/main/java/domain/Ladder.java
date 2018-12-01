package domain;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    ArrayList<Line> ladder;

    private Ladder(ArrayList<Line> ladder) {
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
        ArrayList<Line> newLadder = new ArrayList<>();
        IntStream.range(0, depth).forEach(i -> newLadder.add(Line.from(length)));
        return new Ladder(newLadder);
    }
}
