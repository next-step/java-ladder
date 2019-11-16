package nextstep.ladder.domain;

import java.util.*;

public class Game {

    private final int STEP_MIN_NUM = 1;
    private final int SPOT_MIN_NUM = 2;

    private List<Line> ladder;
    private List<Spot> users;
    private List<Spot> endings;
    private int totalStep;

    public Game(String nameString, String endingString, int totalStep) {
        List<Spot> users = createSpots(nameString);
        List<Spot> endings = createSpots(endingString);

        if (!isValidTotalStep(totalStep) || !isValidSpotPair(users, endings)) {
            throw new IllegalArgumentException();
        }

        this.totalStep = totalStep;
        this.users = users;
        this.endings = endings;
        this.ladder = createLadder(totalStep, users.size());
    }

    private List<Spot> createSpots(String spotString) {
        List<Spot> spots = new ArrayList<>();
        List<String> strings = Arrays.asList(spotString.split(","));
        for (int i = 0; i < strings.size(); i++) {
            spots.add(new Spot(strings.get(i), i));
        }
        if (spots.size() < SPOT_MIN_NUM) {
            throw new IllegalArgumentException();
        }
        return spots;
    }

    private boolean isValidSpotPair(List<Spot> users, List<Spot> endings) {
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

    public List<Spot> getUsers() {
        return Collections.unmodifiableList(this.users);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(this.ladder);
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
}
