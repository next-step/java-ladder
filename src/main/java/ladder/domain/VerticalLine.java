package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.domain.Point.createInitialPoints;

public class VerticalLine {
    private final List<Point> points;

    public VerticalLine(Height height) {
        this.points = createInitialPoints(height.getHeight());
    }

    public VerticalLine(int height) {
        this(new Height(height));
    }

    public static List<VerticalLine> createVerticalLines(int width, Height height) {
        return IntStream.range(0, width)
                .mapToObj(i -> new VerticalLine(height))
                .collect(Collectors.toList());
    }

    public int height() {
        return points.size();
    }

    public void connect(VerticalLine targetLine, int index) {
        if (index < 0 || index >= height()) {
            throw new IllegalArgumentException("존재하지 않는 좌표입니다.");
        }
        if (!points.get(index).isConnected()) {
            points.get(index).connect(targetLine.points.get(index));
        }
    }

    public int connectedCount() {
        return (int) points.stream()
                .filter(Point::isConnected)
                .count();
    }

    public void drawLine(VerticalLine verticalLine, DrawStrategy drawStrategy) {
        for (int i = 0; i < height(); i++) {
            if (drawStrategy.draw()) {
                connect(verticalLine, i);
            }
        }
    }

    public Boolean checkRightConnection(int index) {
        if (index < 0 || index >= height()) {
            throw new IllegalArgumentException("존재하지 않는 좌표입니다.");
        }
        return points.get(index).isRight();
    }
}
