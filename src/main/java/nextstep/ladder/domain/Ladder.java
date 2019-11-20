package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> ladder;

    public Ladder(int totalStep, int spotSize) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < totalStep; i++) {
            ladder.add(new Line(spotSize));
        }
        this.ladder = ladder;
    }

    public int calculateArrival(int departure) {
        int arrival = departure;
        for (int i = 0; i < ladder.size(); i++) {
            arrival = ladder.get(i).move(arrival);
        }
        return arrival;
    }

    public List<Line> getLines() {
        return new ArrayList<>(ladder);
    }
}
