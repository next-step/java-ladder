package nextstep.ladder.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines;

    public Ladder(int numberOfPerson, int height) {
        make(numberOfPerson, height);
    }

    public int doPlay(int start) {
        int x = start;
        int y = 0;
        int height = lines.get(0)
                .getPoints()
                .size();

        while (y < height) {
            Line line = lines.get(x);
            x = line.move(y);

            y++;
        }

        return x;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    private void make(int numberOfPerson, int height) {
        List<Stair> stairs = makeStairs(numberOfPerson, height);

        this.lines = IntStream.range(0, numberOfPerson)
                .mapToObj((index) -> convertLine(index, stairs))
                .collect(Collectors.toList());
    }

    private List<Stair> makeStairs(int numberOfPerson, int height) {
        List<Stair> stairs = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            stairs.add(Stair.of(numberOfPerson));
        }
        return stairs;
    }

    private Line convertLine(int index, List<Stair> stairs) {
        List<Point> points = stairs.stream().map((stair) -> stair.getPoints().get(index))
                .collect(Collectors.toList());
        return new Line(points);
    }

}
