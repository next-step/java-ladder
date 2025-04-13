package nextstep.ladder.model.ladder;

import nextstep.ladder.strategy.RandomPointGenerator;

import java.util.Objects;

public class Point {
    private static final Point TRUE_POINT = new Point(true);
    private static final Point FALSE_POINT = new Point(false);
    
    private final boolean connected;
    
    private Point(final boolean connected) {
        this.connected = connected;
    }
    
    public static Point of(final boolean connected) {
        return connected ? TRUE_POINT : FALSE_POINT;
    }
    
    public static Point create(final RandomPointGenerator pointGenerator) {
        return of(pointGenerator.generate());
    }
    
    public boolean isConnected() {
        return connected;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return connected == point.connected;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(connected);
    }
    
    @Override
    public String toString() {
        return connected ? "연결됨" : "연결되지 않음";
    }
} 
