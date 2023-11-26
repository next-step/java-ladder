package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.RandomCreateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    public static final String NEW_LINE = "\n";
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(int width, int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(width, new RandomCreateStrategy()));
        }

        this.lines = lines;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.lines.forEach(l -> stringBuilder.append(l.toString()).append(NEW_LINE));

        return stringBuilder.toString();
    }

    public Position move(final Position startPosition) {
        Position currentPosition = startPosition;
        for (Line line: this.lines) {
            System.out.println("pre");
            System.out.println(currentPosition.toString());
            currentPosition = line.move(currentPosition);
            System.out.println("post");
            System.out.println(currentPosition.toString());
        }
        System.out.println("============");

        return currentPosition;
    }
}
