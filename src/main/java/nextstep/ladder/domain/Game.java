package nextstep.ladder.domain;

import java.util.*;

public class Game {

    private final int STEP_MIN_NUM = 1;
    private final int SPOT_MIN_NUM = 2;

    private List<Line> ladder;
    private List<String> users;
    private List<String> endings;
    private int totalStep;

    public Game(String nameText, String endingText, int totalStep) {
        List<String> users = createSpots(nameText);
        List<String> endings = createSpots(endingText);

        if (!isValidTotalStep(totalStep) || !isValidSpotPair(users, endings)) {
            throw new IllegalArgumentException();
        }

        this.totalStep = totalStep;
        this.users = users;
        this.endings = endings;
        this.ladder = createLadder(totalStep, users.size());
    }

    private List<String> createSpots(String baseString) {
        List<String> spots = Arrays.asList(baseString.split(","));
        if (!isValidSpot(spots) || spots.size() < SPOT_MIN_NUM) {
            throw new IllegalArgumentException();
        }
        return spots;
    }

    private boolean isValidSpot(List<String> spots) {
        return spots.stream()
                .filter(string -> string == null || "".equals(string.trim()))
                .count() == 0;
    }

    private boolean isValidSpotPair(List<String> users, List<String> endings) {
        return (users.size() == endings.size());
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
        Map<String, String> results = new HashMap<>();
        for (int i = 0; i < users.size(); i++) {
            int arrival = calculateArrival(i);
            results.put(users.get(i), endings.get(arrival));
        }
        return results;
    }

    private int calculateArrival(int departure) {
        int spot = departure;
        for (int i = 0; i < this.ladder.size(); i++) {
            spot = this.ladder.get(i).move(spot);
        }
        return spot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return STEP_MIN_NUM == game.STEP_MIN_NUM &&
                totalStep == game.totalStep &&
                Objects.equals(users, game.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(STEP_MIN_NUM, users, totalStep);
    }

    public Object getLadder() {
        return Collections.unmodifiableList(this.ladder);
    }
}
