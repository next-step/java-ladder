package nextstep.ladder.domain;

import java.util.*;

public class Game {

    private final int STEP_MIN_NUM = 1;

    private Spots spots;
    private List<Line> ladder;

    private int totalStep;
    private int totalSpots;

    public Game(Spots spots, int totalStep) {
        if (!isValidTotalStep(totalStep)) {
            throw new IllegalArgumentException();
        }
        this.totalStep = totalStep;
        this.totalSpots = spots.getUserSize();
        this.spots = spots;
        this.ladder = createLadder(totalStep, totalSpots);
    }

    private boolean isValidTotalStep(int totalStep) {
        return (totalStep >= STEP_MIN_NUM);
    }

    private List<Line> createLadder(int totalStep, int spotSize) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < totalStep; i++) {
            ladder.add(new Line(spotSize));
        }
        return ladder;
    }

    public Map<String, String> doGame() {
        List<Integer> arrivals = new ArrayList<>();
        for (int i = 0; i < totalSpots; i++) {
            arrivals.add(calculateArrival(i));
        }
        return this.spots.getSpotResult(arrivals);
    }

    private int calculateArrival(int departure) {
        int spot = departure;
        for (int i = 0; i < this.ladder.size(); i++) {
            spot = this.ladder.get(i).move(spot);
        }
        return spot;
    }

    public Object getLadder() {
        return Collections.unmodifiableList(this.ladder);
    }
}
