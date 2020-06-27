package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(false);
        }
    }

    public void generateLine(Random random) {
        boolean prev = false;
        for (int i = 0; i < points.size(); i++) {
            prev = !prev && random.nextBoolean();
            points.set(i, prev);
        }
    }

    @Override
    public String toString() {
        return "  |" + points.stream()
                .map(point -> point ? "-----" : "     ")
                .collect(Collectors.joining("|"))
                + "|";
    }
}
