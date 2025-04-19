package nextstep.ladder.model.ladder;

import nextstep.ladder.strategy.RandomPointGenerator;

import java.util.Objects;

public class Point {
    private static final Point CONNECTED_POINT = new Point(true);
    private static final Point DISCONNECTED_POINT = new Point(false);
    
    private final boolean connected;
    
    private Point(final boolean connected) {
        this.connected = connected;
    }
    
    public static Point of(final boolean connected) {
        return connected ? CONNECTED_POINT : DISCONNECTED_POINT;
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
} 
