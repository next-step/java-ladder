package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int STEP_MIN_NUM = 1;

    private List<Line> ladder;

    public Ladder(int totalStep, int spotSize) {
        this.ladder = generateLadder(totalStep, spotSize);
    }

    private List<Line> generateLadder(int totalStep, int spotSize) {
        if (!isValidTotalStep(totalStep)) {
            throw new IllegalArgumentException("사다리 높이는 1층 이상이어야 합니다");
        }

        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < totalStep; i++) {
            ladder.add(new Line(spotSize));
        }
        return ladder;
    }

    private boolean isValidTotalStep(int totalStep) {
        return (totalStep >= STEP_MIN_NUM);
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
