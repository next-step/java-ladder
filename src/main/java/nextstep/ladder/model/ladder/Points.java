package nextstep.ladder.model.ladder;

import nextstep.ladder.model.player.Players;
import nextstep.ladder.strategy.RandomPointGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Points {
    private final List<Point> points;

    private Points(final List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public static Points create(final Players players, final RandomPointGenerator pointGenerator) {
        List<Point> generatedPoints = new ArrayList<>();
        IntStream.range(0, players.count() - 1).forEach(i -> {
            if (i > 0 && generatedPoints.get(i - 1).isConnected()) {
                generatedPoints.add(Point.of(false));
                return;
            }
            generatedPoints.add(Point.create(pointGenerator));
        });
        return new Points(generatedPoints);
    }
    
    public boolean hasLine(final Position position) {
        if (!isValidPosition(position)) {
            return false;
        }
        return points.get(position.getValue()).isConnected();
    }
    
    public boolean isValidPosition(final Position position) {
        return position.getValue() >= 0 && position.getValue() < points.size();
    }
    
    public int size() {
        return points.size();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
    
    @Override
    public String toString() {
        return points.toString();
    }
} 
