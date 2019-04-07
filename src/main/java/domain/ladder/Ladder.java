package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> ladder;

    public Ladder(int ladderHeight, int userCount) {
        ladder = generate(ladderHeight, userCount);
    }

    public List<Line> generate(int ladderHight, int userCount) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHight; i++) {
            lines.add(new Line().generate(userCount));
        }
        return lines;
    }

    public int size() {
        return ladder.size();
    }

    public String toString(int margin) {
        String result = "";
        for (Line line : ladder) {
            result += line.toString(margin);
            result += "\n";
        }
        return result;
    }
}
