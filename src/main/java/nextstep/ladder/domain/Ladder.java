package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> ladder = new ArrayList<>();
    private Location currentLocation;
    private int height;
    private int line;

    public Ladder(int line, int height) {
        this.height = height;
        this.line = line;
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(line));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public Location play() {
        currentLocation = new Location(line);
        for (int i = 0; i < height; i++) {
            currentLocation.move(ladder.get(i).getLocation());
        }
        return currentLocation;
    }
}
