package domain;

import java.util.ArrayList;

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
        for(int i = 0; i < depth; i++) {
            newLadder.add(new Line(length));
        }
        return new Ladder(newLadder);
    }
}
