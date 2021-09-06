package nextstep.ladder.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines;
    private static final Random RANDOM = new Random();

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
        List<Point>[] pointLists = IntStream.range(0, numberOfPerson)
                .mapToObj((index) -> new ArrayList<Point>())
                .toArray(List[]::new);

        for (int index = 0; index < height; index++) {
            makeStairs(pointLists, index);
        }

        this.lines = Arrays.stream(pointLists)
                .map((pointList -> new Line(pointList)))
                .collect(Collectors.toList());
    }

    private void makeStairs(List<Point>[] pointLists, int y) {
        for (int x = 0; x < pointLists.length; x++) {
            makeStair(pointLists, x, y);
        }
    }

    private void makeStair(List<Point>[] pointLists, int x, int y) {
        if (pointLists[x].size() > y) {
            return;
        }

        if (x == pointLists.length - 1) {
            pointLists[x].add(new Point(x, Direction.straight()));
            return;
        }

        if (RANDOM.nextBoolean()) {
            pointLists[x].add(new Point(x, Direction.right()));
            pointLists[x + 1].add(new Point(x + 1, Direction.left()));
            return;
        }

        pointLists[x].add(new Point(x, Direction.straight()));
    }

}
