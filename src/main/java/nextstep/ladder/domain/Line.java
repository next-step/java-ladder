package nextstep.ladder.domain;

import nextstep.ladder.utils.RandomLineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfParticipant) {
        this(generateRandomLine(countOfParticipant));
    }

    private static ArrayList<Boolean> generateRandomLine(int countOfParticipant) {
        ArrayList<Boolean> booleans = new ArrayList<>();
        booleans.add(false);

        for (int i = 1; i < countOfParticipant; i++) {
            boolean shouldGenerateLine = !booleans.get(i - 1) && RandomLineGenerator.generateLine();
            booleans.add(shouldGenerateLine);
        }
        return booleans;
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
