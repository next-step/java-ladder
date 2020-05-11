package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> ladder = new ArrayList<>();

    public Ladder(Height height, Players players) {
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.add(new Line(players.getSize()));
        }
    }

    public void showLadder() {
        for (int i = 0; i < ladder.size(); i++) {
            ladder.get(i).showPoint();
            System.out.println("");
        }
    }

}
